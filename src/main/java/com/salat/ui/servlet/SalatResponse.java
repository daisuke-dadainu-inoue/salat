/** サーブレットクラス */
package com.salat.ui.servlet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/** Salatレスポンスクラス */
public class SalatResponse extends HttpServletResponseWrapper {

    /**
     * デフォルトコンストラクタ
     *
     * @param response
     */
    public SalatResponse(HttpServletResponse response) {
        super(response);
    }

}
