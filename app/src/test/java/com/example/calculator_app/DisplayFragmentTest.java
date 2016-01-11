package com.example.calculator_app;

import android.os.Build;
import android.widget.EditText;

import com.example.calculator_app.events.AppendEvent;
import com.example.calculator_app.events.BaseEvent;
import com.example.calculator_app.events.DisplayEvent;
import com.example.calculator_app.events.OperatorEvent;
import com.example.calculator_app.events.SetDisplayEvent;
import com.example.support.BusHelper;
import com.example.support.ViewLocator;
import com.squareup.otto.Bus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.example.support.Assert.assertViewIsVisible;
import static com.example.support.ResourceLocator.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class DisplayFragmentTest {


    public static final String TEST_VALUE = "Test";
    public static final String TEST_OPERATOR = "%";
    private DisplayFragment mDisplayFragment;
    private EditText mCalculatorDisplay;
    private Bus mBus;


    @Before
    public void setUp() throws Exception {
        mDisplayFragment = DisplayFragment.newInstance();
        startFragment(mDisplayFragment);

        mCalculatorDisplay = (EditText) ViewLocator.getView(mDisplayFragment, R.id.calculator_display);
        mBus = CalculatorApplication.getInstance().getBus();
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mDisplayFragment);
    }

    @Test
    public void shouldHaveDisplay() throws Exception {
        assertViewIsVisible(mCalculatorDisplay);
        assertValueDisplayed(getString(R.string.default_display_text));
    }

    @Test
    public void shouldUpdateBlankDisplayAfterAppendEvent() throws Exception {
        mCalculatorDisplay.setText(""); // ADDED - blank the display
        mBus.post(new AppendEvent(TEST_VALUE));
        assertThat(mCalculatorDisplay.getText().toString(), equalTo(TEST_VALUE));
    }


    @Test
    public void shouldUpdateDisplayAfterOperatorEvent() throws Exception {
        mBus.post(new OperatorEvent(TEST_OPERATOR));
        assertValueDisplayed(TEST_OPERATOR);
    }

    @Test
    public void appendEventShouldAppendDisplay() throws Exception {
        mCalculatorDisplay.setText(TEST_VALUE);
        mBus.post(new AppendEvent(TEST_VALUE));
        assertThat(mCalculatorDisplay.getText().toString(),
                equalTo(TEST_VALUE + TEST_VALUE));
    }

    @Test
    public void shouldSetDisplayOnSetDisplayEvent() throws Exception {
        postSetDisplayEvent();
        assertThat(mCalculatorDisplay.getText().toString(), equalTo(TEST_VALUE));

    }

    private void postSetDisplayEvent() {
        mBus.post(new SetDisplayEvent(TEST_VALUE));
    }


    private void assertValueDisplayed(String value) {
        assertThat(mCalculatorDisplay.getText().toString(), equalTo(value));
    }




}
