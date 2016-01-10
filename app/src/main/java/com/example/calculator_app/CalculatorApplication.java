package com.example.calculator_app;

import android.app.Application;

import com.squareup.otto.Bus;

public class CalculatorApplication extends Application{

    private Bus mBus;

    private static CalculatorApplication instance = new CalculatorApplication();

    public static CalculatorApplication newInstance() {
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
}
