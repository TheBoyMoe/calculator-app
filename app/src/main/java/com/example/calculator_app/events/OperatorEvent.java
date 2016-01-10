package com.example.calculator_app.events;


public class OperatorEvent extends BaseEvent{

    private final String mOperator;

    public OperatorEvent(String operator) {
        mOperator = operator;
    }

    public String getOperator() {
        return mOperator;
    }
}
