/** サーブレットパッケージ */

package com.salat.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.inject.Singleton;

/** SalatServlet */
@Singleton
public class SalatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /** ゲットメソッド */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Hello Salat");
    }

    /** ポストメソッド */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
