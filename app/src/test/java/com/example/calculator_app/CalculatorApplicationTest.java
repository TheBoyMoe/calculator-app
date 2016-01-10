package com.example.calculator_app;


import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class CalculatorApplicationTest {


    private CalculatorApplication mApplication;

    @Before
    public void setUp() throws Exception {
        mApplication = CalculatorApplication.newInstance();
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mApplication);
    }

    @Test
    public void shouldHaveBus() throws Exception {
        assertNotNull(mApplication.getBus());

    }
}
