package com.example.calculator_app;

import android.app.Application;

public class CalculatorApplication extends Application{

    private static CalculatorApplication instance = new CalculatorApplication();

    public static CalculatorApplication newInstance() {
        return instance;
    }


}
