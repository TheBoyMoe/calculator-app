package com.example.calculator_app.events;

public class DisplayEvent extends BaseEvent{

    private String mValue;

    public DisplayEvent(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }
}
