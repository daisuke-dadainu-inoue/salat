/** 設定パッケージ */

package com.salat.common.config;

import static java.lang.Thread.currentThread;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/** Salatモジュール */
public class SalatInjector extends AbstractModule {

    /** プロパティ名 */
    private final String PROPERTY_NAME = "salat.properties";

    /** 設定 */
    @Override
    protected void configure() {

        // 設定ファイルバインド
        try (InputStream inputStream = currentThread().getContextClassLoader().getResourceAsStream(PROPERTY_NAME);) {
            Names.bindProperties(binder(), loadProperties(inputStream));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // サーブレット・フィルタ登録
        install(new SalatModule());
    }

    /**
     * プロパティ読込
     *
     * @param inputStream
     *            入力ストリーム
     * @return Properties
     * @throws IOException
     */
    private Properties loadProperties(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        if (inputStream != null) {
            properties.load(inputStream);
        }
        return properties;
    }
}
