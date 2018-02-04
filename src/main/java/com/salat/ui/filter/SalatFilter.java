/** フィルターパッケージ */
package com.salat.ui.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.inject.Singleton;

/** Salatフィルタークラス */
@Singleton
public class SalatFilter implements Filter {

    /** 初期化メソッド */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 子クラス実装
    }

    /** フィルターメソッド */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest hRequest = (HttpServletRequest) request;
        HttpServletResponse hResponse = (HttpServletResponse) response;

        try {
            String user = hRequest.getParameter("user");
            String password = hRequest.getParameter("password");
            if ("".equals(user) || "".equals(password)) {
                throw new ServletException("user/password is not empty");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            hResponse.sendRedirect("./");
            return;
        }
        chain.doFilter(request, response);
    }

    /** フィルターメソッド */
    @Override
    public void destroy() {
        // 子クラス実装
    }
}
