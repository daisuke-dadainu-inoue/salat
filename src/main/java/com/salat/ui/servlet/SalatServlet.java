/** サーブレットパッケージ */

package com.salat.ui.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.inject.Singleton;
import com.salat.ui.base.BaseServlet;

/** Salatサーブレットクラス */
@Singleton
public class SalatServlet extends BaseServlet {

    /** シリアライズバージョンID */
    private static final long serialVersionUID = 1L;

    /** ゲットメソッド */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.getWriter().println("Hello Salat");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
