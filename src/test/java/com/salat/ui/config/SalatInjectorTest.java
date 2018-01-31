/** 設定パッケージ */
package com.salat.ui.config;

import static org.mockito.MockitoAnnotations.initMocks;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/** SalatInjectorをテストするクラス */
@RunWith(JMockit.class)
public class SalatInjectorTest {
    @InjectMocks
    private SalatInjector si;
    @Mocked
    private Binder binder;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void test() {
        new Expectations() {
            {
                Names.bindProperties(binder, new Properties());
                minTimes = 0;
            }
        };
        new MockUp<AbstractModule>() {
            @Mock
            protected void install(Module module) {
            }

            @Mock
            protected Binder binder() {
                return binder;
            }
        };
        si.configure();
    }

    @After
    public void tearDown() {

    }
}
