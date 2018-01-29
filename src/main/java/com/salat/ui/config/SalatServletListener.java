/** 設定パッケージ */
package com.salat.ui.config;

import javax.servlet.annotation.WebListener;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/** Salatサーブレットリスナークラス */
@WebListener
public class SalatServletListener extends GuiceServletContextListener {

    /** インジェクター取得メソッド */
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new SalatInjector());
    }

}
