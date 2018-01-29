/** サーブレットパッケージ */
package com.salat.ui.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.salat.ui.base.BaseServlet;

/** Pingサーブレットクラス */
public class PingServlet extends BaseServlet {

    /** シリアライズバージョンID */
    private static final long serialVersionUID = 1L;

    /** ゲットメソッド */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.getWriter().println("OK!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
