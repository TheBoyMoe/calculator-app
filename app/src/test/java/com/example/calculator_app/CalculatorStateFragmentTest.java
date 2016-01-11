package com.example.calculator_app;

import android.os.Build;

import com.example.calculator_app.events.AppendEvent;
import com.example.calculator_app.events.BaseEvent;
import com.example.calculator_app.events.NumberEvent;
import com.example.calculator_app.events.OperatorEvent;
import com.example.calculator_app.events.SetDisplayEvent;
import com.example.support.BusHelper;
import com.squareup.otto.Bus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class CalculatorStateFragmentTest {


    public static final String NUMBER_VALUE = "1";
    private static final String OPERATOR = "%";
    private CalculatorStateFragment mStateFragment;
    private Bus mBus;
    private BusHelper mBusHelper;


    @Before
    public void setUp() throws Exception {
        mStateFragment = CalculatorStateFragment.newInstance();
        startFragment(mStateFragment);

        mBus = CalculatorApplication.getInstance().getBus();
        mBusHelper = new BusHelper();
        mBus.register(mBusHelper);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mStateFragment);
    }


    @Test
    public void numberEventShouldFireAppendEvent() throws Exception {
        postNumberEvent();

        BaseEvent event = mBusHelper.getLastEvent();
        assertTrue(event instanceof AppendEvent);
        assertThat(mBusHelper.numberOfEvents(), equalTo(2));
        assertThat(((AppendEvent) event).getValue(), equalTo(NUMBER_VALUE));

    }

    @Test
    public void shouldSetDisplayAfterOperatorEvent() throws Exception {

        postNumberEvent();
        postOperatorEvent();
        postNumberEvent();

        BaseEvent lastEvent = mBusHelper.getLastEvent();
        assertTrue(lastEvent instanceof SetDisplayEvent);
        assertThat(((SetDisplayEvent)lastEvent).getValue(), equalTo(NUMBER_VALUE));
    }


    private void postOperatorEvent() {
        mBus.post(new OperatorEvent(OPERATOR));
    }

    private void postNumberEvent() {
        // post a number event to the bus and check that it triggers an append event
        mBus.post(new NumberEvent(NUMBER_VALUE));
    }

}