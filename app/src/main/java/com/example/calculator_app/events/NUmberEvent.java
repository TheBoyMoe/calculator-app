package com.example.calculator_app.events;


public class NumberEvent extends BaseEvent{

    private String mNumber;

    public NumberEvent(String number) {
        mNumber = number;
    }

    public String getNumber() {
        return mNumber;
    }
}
