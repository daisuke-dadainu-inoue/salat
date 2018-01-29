/** サーブレットパッケージ */
package com.salat.ui.base;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** サーブレットベースクラス */
public abstract class BaseServlet extends HttpServlet {

    /** シリアライズバージョンID */
    private static final long serialVersionUID = 1L;

    /** ゲットメソッド */
    @Override
    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp);

    /** ポストメソッド */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
