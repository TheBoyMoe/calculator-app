package com.example.calculator_app;

import android.os.Build;

import com.example.calculator_app.events.BaseEvent;
import com.example.calculator_app.events.DisplayEvent;
import com.example.calculator_app.events.NumberEvent;
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
    public void numberEventShouldFireDisplayEvent() throws Exception {

        // post a number event to the bus and check that it triggers a display event by DisplayFragment
        String number = "1";
        mBus.post(new NumberEvent(number));

        BaseEvent event = mBusHelper.getLastEvent();
        assertTrue(event instanceof DisplayEvent);
        assertThat(mBusHelper.numberOfEvents(), equalTo(2));
        assertThat(((DisplayEvent) event).getValue(), equalTo(number));

    }

}