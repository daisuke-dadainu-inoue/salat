/** 設定パッケージ */
package com.salat.ui.config;

import com.google.inject.servlet.ServletModule;
import com.salat.ui.servlet.SalatServlet;

/** Salatモジュールクラス */
public class SalatModule extends ServletModule {

    /** サーブレット設定メソッド */
    @Override
    protected void configureServlets() {
        installFilter();
        installServlet();
    }

    /**
     * フィルターインストールメソッド
     */
    private void installFilter() {
        // filter(SalatUrl.HELLO).through(SalatFilter.class);
    }

    /**
     * サーブレットインストールメソッド
     */
    private void installServlet() {
        serve(SalatUrl.HELLO).with(SalatServlet.class);
    }
}
