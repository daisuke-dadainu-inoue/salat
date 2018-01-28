/** 設定パッケージ */
package com.salat.sui.config;

import com.google.inject.servlet.ServletModule;
import com.salat.sui.filter.SalatFilter;
import com.salat.sui.servlet.SalatServlet;

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
