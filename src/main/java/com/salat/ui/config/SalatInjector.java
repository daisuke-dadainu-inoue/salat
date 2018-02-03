/** 設定パッケージ */

package com.salat.ui.config;

import static java.lang.Thread.currentThread;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/** Salatインジェクタークラス */
public class SalatInjector extends AbstractModule {

    /** プロパティ名 */
    private final String PROPERTY_NAME = "config/common/salat.properties";

    /** 設定メソッド */
    @Override
    protected void configure() {
        // 設定ファイルバインド
        bindProperties();
        // サーブレット・フィルタ登録
        install(new SalatModule());
    }

    /** 設定ファイルバインド */
    public void bindProperties() {
        try (InputStream inputStream = currentThread().getContextClassLoader().getResourceAsStream(PROPERTY_NAME);) {
            Names.bindProperties(binder(), loadProperties(inputStream));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * プロパティ読込メソッド
     *
     * @param inputStream
     *            入力ストリーム
     * @return Properties
     * @throws IOException
     */
    public Properties loadProperties(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        if (inputStream != null) {
            properties.load(inputStream);
        }
        return properties;
    }
}
