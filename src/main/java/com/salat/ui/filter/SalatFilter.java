/** フィルターパッケージ */
package com.salat.ui.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** Salatフィルタークラス */
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
        // 子クラス実装
    }

    /** フィルターメソッド */
    @Override
    public void destroy() {
        // 子クラス実装
    }
}
