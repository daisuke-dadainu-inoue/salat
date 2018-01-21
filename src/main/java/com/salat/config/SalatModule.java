/** 設定パッケージ */

package com.salat.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.google.inject.servlet.ServletModule;
import com.salat.servlet.SalatServlet;

/** Salatモジュール */
public class SalatModule extends AbstractModule {

    /** 設定 */
    @Override
    protected void configure() {
        // 設定ファイルバインド
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("salat.properties");) {
            Properties properties = new Properties();
            if (inputStream != null) {
                properties.load(inputStream);
            }
            Names.bindProperties(binder(), properties);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // Servlet登録
        install(new ServletModule() {
            @Override
            protected void configureServlets() {
                // Filter

                // Servlet
                serve("/hello").with(SalatServlet.class);
            }
        });
    }
}
