/** サーブレットパッケージ */
package com.salat.ui.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/** Salatリクエストクラス */
public class SalatRequest extends HttpServletRequestWrapper {

    /**
     * デフォルトコンストラクタ
     *
     * @param request
     */
    public SalatRequest(HttpServletRequest request) {
        super(request);
    }

}
