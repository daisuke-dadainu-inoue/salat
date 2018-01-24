package com.salat.common.controller.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.html.HtmlEscapers;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.salat.exception.ValidationException;

/** Citrus 用リクエストラッパ */
public class SalatHttpServletRequest extends HttpServletRequestWrapper {

    private static final int TOKEN_LENGTH = 4;
    /** サイトIDのインデックス */
    private static final int SID_INDEX = 2;
    /** ページパスのインデックス */
    private static final int PAGE_PATH_INDEX = 3;

    /** スプリットされたパス */
    private String[] tokens;

    /**
     * コンストラクタ
     *
     * @param request
     *            requset
     */
    public SalatHttpServletRequest(HttpServletRequest request) {
        super(request);
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String uri = getRequestURI();
        tokens = uri.split("/", TOKEN_LENGTH);
        if (tokens.length == TOKEN_LENGTH - 1) {
            tokens = (uri + "/").split("/", TOKEN_LENGTH);
        } else if (tokens.length < TOKEN_LENGTH - 1) {
            throw new ValidationException("不正な URL でリクエストされました");
        }
    }

    /**
     * <pre>
     * サイトIDを取得します
     * </pre>
     *
     * @return 取得されたサイトID
     */
    public String getSiteId() {
        return tokens[SID_INDEX];
    }

    /**
     * <pre>
     * ページを取得します
     * </pre>
     *
     * @return 取得されたページ
     */
    public String getPage() {
        String page = tokens[PAGE_PATH_INDEX];
        String last = Iterables.getLast(Arrays.asList(page.split("/")));
        if (last.contains(".")) {
            page = page.replace(last, last.split("\\.", 2)[0]);
        }
        return page;
    }

    /**
     * <pre>
     * 言語の指定を取得します
     * </pre>
     *
     * @return 取得された言語。未指定の場合は日本語
     */
    public Locale getLanguage() {
        String lang = getParameter("lang");
        if (Strings.isNullOrEmpty(lang)) {
            return Locale.JAPANESE;
        }
        // 未定義の LanguageTag でも null にはなりません
        return Locale.forLanguageTag(lang);
    }

    /**
     * <pre>
     * User-Agent の値を取得します
     * </pre>
     *
     * @return User-Agent
     */
    public String getUserAgent() {
        String userAgent = getHeader("User-Agent");
        return Strings.isNullOrEmpty(userAgent) ? "" : userAgent;
    }

    /**
     * POST されたコンテンツを JsonElement として取得します
     *
     * @return JsonElement
     */
    public JsonElement getPostedJson() {
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader reader = getReader();
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            return null;
        }

        JsonParser parser = new JsonParser();
        String buf = buffer.toString();
        if (Strings.isNullOrEmpty(buf)) {
            return null;
        }
        try {
            return parser.parse(buf);
        } catch (JsonParseException e) {
            throw new ValidationException("不正な JSON が POST されました");
        }
    }

    /**
     * <pre>
     * basis-time の値を取得します<br />
     * data format: yyyy-MM-dd'T'HH:mm
     * </pre>
     *
     * @return 指定された日付
     */
    public Date getBasisTime() {
        String basisTime = getParameter("basis-time");
        if (Strings.isNullOrEmpty(basisTime)) {
            // now を返却すると現在時刻の判定で苦労しそうなので、null を返却することにします
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            return format.parse(basisTime);
        } catch (ParseException e) {
            // 指定外のフォーマットできた場合は無視します
            return null;
        }
    }

    /**
     * <pre>
     * パラメータをMapで取得します
     * </pre>
     *
     * @return パラメータMap
     */
    public Map<String, String> getRequestMap() {

        Map<String, String[]> map = getParameterMap();
        Map<String, String> resultMap = Maps.newHashMap();
        for (Entry<String, String[]> e : map.entrySet()) {
            resultMap.put(e.getKey(), e.getValue()[0]);
        }

        return resultMap;
    }

    /**
     * <pre>
     * パラメータを取得します<br />
     * </pre>
     *
     * @return htmlエスケープされたパラメータ
     */
    @Override
    public String getParameter(String key) {
        String value = super.getParameter(key);
        if (value == null) {
            return value;
        }
        return HtmlEscapers.htmlEscaper().escape(value);
    }

    /**
     * <pre>
     * パラメータマップを取得します<br />
     * </pre>
     *
     * @return htmlエスケープされたパラメータのマップ
     */
    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> map = super.getParameterMap();
        Map<String, String[]> escapedMap = Maps.newHashMap();

        for (Map.Entry<String, String[]> param : map.entrySet()) {
            String key = HtmlEscapers.htmlEscaper().escape(param.getKey());
            String[] arr = { HtmlEscapers.htmlEscaper().escape(param.getValue()[0]) };
            escapedMap.put(key, arr);
        }

        return escapedMap;
    }

}
