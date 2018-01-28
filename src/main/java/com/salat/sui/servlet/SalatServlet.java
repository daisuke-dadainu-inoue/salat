/** servletPackage */

package com.salat.sui.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.inject.Singleton;

/** SalatServlet */
@Singleton
public class SalatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /** GetMethod */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.getWriter().println("Hello Salat");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /** PostMethod */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
