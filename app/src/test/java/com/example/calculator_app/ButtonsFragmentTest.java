package com.example.calculator_app;

import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class ButtonsFragmentTest {

    private ButtonsFragment mButtonsFragment;

    @Before
    public void setUp() throws Exception {
        mButtonsFragment = ButtonsFragment.newInstance();
        startFragment(mButtonsFragment);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mButtonsFragment);
    }
}
