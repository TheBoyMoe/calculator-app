package com.example.calculator_app;

import android.os.Build;

import com.example.support.ViewLocator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.example.support.Assert.assertViewIsVisible;
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

    @Test
    public void shouldHaveButtons() throws Exception {
        assertViewIsVisible(ViewLocator.getView(mButtonsFragment, R.id.fragment_buttons));
    }

    @Test
    public void shouldHaveOneButton() throws Exception {
        assertViewIsVisible(ViewLocator.getView(mButtonsFragment, R.id.button_one));
    }


}
