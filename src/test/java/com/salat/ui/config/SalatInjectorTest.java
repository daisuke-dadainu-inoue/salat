/** 設定パッケージ */
package com.salat.ui.config;

import static org.junit.Assert.fail;
import java.io.IOException;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

/** SalatInjectorをテストするクラス */
@RunWith(JMockit.class)
public class SalatInjectorTest {

    @Tested
    private SalatInjector si;

    @Mocked
    Binder mockBinder;

    /**
     * 事前準備
     */
    @Before
    public void setUp() {
        si = new SalatInjector();
    }

    /**
     * 設定メソッドテスト001_正常系
     */
    @SuppressWarnings("unused")
    @Test
    public void testConfigure001() {
        new MockUp<AbstractModule>() {
            @Mock
            protected void install(Module module) {
                // 空実装
            }

            @Mock
            protected Binder binder() {
                return mockBinder;
            }
        };

        new MockUp<Names>() {
            @Mock
            void bindProperties(Binder binder, Properties properties) {
                // 空実装
            }
        };
        si.configure();
    }

    /**
     * 設定ファイルバインドメソッドテスト001_正常系
     */
    @SuppressWarnings("unused")
    @Test
    public void testBindProperties001() {
        new MockUp<AbstractModule>() {
            @Mock
            protected void install(Module module) {
                // 空実装
            }

            @Mock
            protected Binder binder() {
                return mockBinder;
            }
        };

        new MockUp<Names>() {
            @Mock
            void bindProperties(Binder binder, Properties properties) {
                // 空実装
            }
        };
        si.bindProperties();
    }

    /**
     * 設定ファイルバインドメソッドテスト002_異常系
     */
    @SuppressWarnings("unused")
    @Test
    public void testBindProperties002() {
        new MockUp<AbstractModule>() {
            @Mock
            protected Binder binder() {
                return mockBinder;
            }
        };

        new MockUp<Names>() {
            @Mock
            void bindProperties(Binder binder, Properties properties) throws IOException {
                throw new IOException();
            }
        };
        si.bindProperties();
    }

    /**
     * プロパティ読込メソッドテスト001_正常系
     */
    @Test
    public void testLoadProperties001() {
        try {
            si.loadProperties(Thread.currentThread().getContextClassLoader().getResourceAsStream("salat.properties"));
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    /**
     * プロパティ読込メソッドテスト002_異常系
     */
    @Test
    public void testLoadProperties002() {
        try {
            si.loadProperties(null);
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    /**
     * 事後準備
     */
    @After
    public void tearDown() {
        // 空実装
    }
}
