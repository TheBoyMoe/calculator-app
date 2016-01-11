package com.example.calculator_app;

import android.app.Fragment;
import android.os.Build;

import com.example.calculator_app.events.BaseEvent;
import com.example.calculator_app.events.DisplayEvent;
import com.example.calculator_app.events.NumberEvent;
import com.example.support.BusHelper;
import com.squareup.otto.Bus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class CalculatorActivityTest {


    private CalculatorActivity mCalculatorActivity;
    private Bus mBus;
    private BusHelper mBusHelper;


    @Before
    public void setUp() throws Exception {
        mCalculatorActivity = Robolectric.buildActivity(CalculatorActivity.class)
                    .create()
                    .resume()
                    .get();

        mBus = CalculatorApplication.getInstance().getBus();
        mBusHelper = new BusHelper();
        mBus.register(mBusHelper);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mCalculatorActivity);
    }


    @Test
    public void shouldHaveDisplayFragment() throws Exception {
        assertNotNull(getFragmentById(R.id.display_fragment_container));
    }

    @Test
    public void shouldHaveButtonsFragment() throws Exception {
        assertNotNull(getFragmentById(R.id.buttons_fragment_container));

    }

    private Fragment getFragmentById(int id) {
        return mCalculatorActivity.getFragmentManager().findFragmentById(id);
    }

    @Test
    public void numberEventShouldFireDisplayEvent() throws Exception {

        // post a number event to the bus and check that it triggers a display event by DisplayFragment
        String number = "1";
        mBus.post(new NumberEvent(number));

        BaseEvent event = mBusHelper.getLastEvent();
        assertTrue(event instanceof DisplayEvent);
        assertThat(mBusHelper.numberOfEvents(), equalTo(2));
        assertThat(((DisplayEvent)event).getValue(), equalTo(number));

    }


    @Test
    public void shouldHaveCalculatorStateFragment() throws Exception {
        Fragment stateFragment = getStateFragment();
        assertNotNull(stateFragment);
        assertTrue(stateFragment instanceof CalculatorStateFragment);
    }

    private Fragment getStateFragment() {
        return mCalculatorActivity.getFragmentManager()
                .findFragmentByTag(CalculatorActivity.STATE_FRAGMENT_TAG);
    }
}