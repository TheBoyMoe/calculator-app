package com.example.calculator_app;

import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class CalculatorActivityTest {


    private CalculatorActivity mCalculatorActivity;

    @Before
    public void setUp() throws Exception {
        mCalculatorActivity = Robolectric.buildActivity(CalculatorActivity.class)
                    .create()
                    .resume()
                    .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mCalculatorActivity);
    }


    @Test
    public void shouldHaveDisplayFragment() throws Exception {
        assertNotNull(mCalculatorActivity.getFragmentManager()
                .findFragmentById(R.id.display_fragment_container));
    }

    @Test
    public void shouldHaveButtonsFragment() throws Exception {
        assertNotNull(mCalculatorActivity.getFragmentManager()
                .findFragmentById(R.id.buttons_fragment_container));

    }
}