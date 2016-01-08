package com.example.calculator_app;

import android.os.Build;
import android.widget.EditText;

import com.example.support.ResourceLocator;
import com.example.support.ViewLocator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.example.support.Assert.assertViewIsVisible;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class DisplayFragmentTest {


    private DisplayFragment mDisplayFragment;
    private EditText mCalculatorDisplay;

    @Before
    public void setUp() throws Exception {
        mDisplayFragment = DisplayFragment.newInstance();
        startFragment(mDisplayFragment);

        mCalculatorDisplay = (EditText) ViewLocator.getView(mDisplayFragment, R.id.calculator_display);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mDisplayFragment);
    }

    @Test
    public void shouldHaveDisplay() throws Exception {
        assertViewIsVisible(mCalculatorDisplay);
        assertThat(mCalculatorDisplay.getText().toString(),
                equalTo(ResourceLocator.getString(R.string.default_display_text)));
    }



}
