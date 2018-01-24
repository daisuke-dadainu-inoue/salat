/** 設定パッケージ */
package com.salat.common.config;

import com.google.inject.servlet.ServletModule;
import com.salat.common.controller.filter.SalatFilter;
import com.salat.common.controller.servlet.SalatServlet;

/** SalatModule */
public class SalatModule extends ServletModule {

    /** サーブレット設定 */
    @Override
    protected void configureServlets() {
        installFilter();
        installServlet();
    }

    /**
     * フィルターインストール
     */
    private void installFilter() {
        filter("/hello").through(SalatFilter.class);
    }

    /**
     * サーブレットインストール
     */
    private void installServlet() {
        serve("/hello").with(SalatServlet.class);
    }
}
