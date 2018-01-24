/** 設定パッケージ */
package com.salat.common.config;

import javax.servlet.annotation.WebListener;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/** Guiceサーブレット設定 */
@WebListener
public class SalatServletListener extends GuiceServletContextListener {

    /** インジェクター取得 */
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new SalatInjector());
    }

}
