package com.example.calculator_app;

import android.app.Fragment;

import com.example.calculator_app.events.BaseEvent;
import com.squareup.otto.Bus;

/**
 * Provides central location from where registering/unregistering to the event bus
 * and posting and retrieving the bus can occur
 */
public class BaseFragment extends Fragment{

    public BaseFragment() {}


    @Override
    public void onResume() {
        super.onResume();
        getAppBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getAppBus().unregister(this);
    }

    protected Bus getAppBus() {
        return CalculatorApplication.getInstance().getBus();
    }

    protected void postToBus(BaseEvent event) {
        CalculatorApplication.postToBus(event);
    }

}
