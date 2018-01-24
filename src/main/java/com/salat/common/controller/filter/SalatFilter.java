/**
 *
 */
package com.salat.common.controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** ServletFilter */
public class SalatFilter implements Filter {

    /** 初期化メソッド */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO 自動生成されたメソッド・スタブ
    }

    /** フィルターメソッド */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO 自動生成されたメソッド・スタブ
    }

    /** フィルターメソッド */
    @Override
    public void destroy() {
        // TODO 自動生成されたメソッド・スタブ
    }
}
