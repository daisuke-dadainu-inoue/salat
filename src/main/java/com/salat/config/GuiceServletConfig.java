/** 設定パッケージ */
package com.salat.config;

import javax.servlet.annotation.WebListener;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.salat.servlet.SalatServlet;

/** Guiceサーブレット設定 */
@WebListener
public class GuiceServletConfig extends GuiceServletContextListener {

    /** インジェクター取得 */
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                serve("/hello").with(SalatServlet.class);
            }
        });
    }

}
