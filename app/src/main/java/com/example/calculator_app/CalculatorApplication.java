package com.example.calculator_app;

import android.app.Application;

import com.example.calculator_app.events.BaseEvent;
import com.squareup.otto.Bus;

public class CalculatorApplication extends Application{

    private Bus mBus;

    private static CalculatorApplication instance = new CalculatorApplication();

    public static CalculatorApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance.mBus = new Bus();
    }

    public Bus getBus() {
        return mBus;
    }

    public static void postToBus(BaseEvent event) {
        getInstance().getBus().post(event);
    }


}
