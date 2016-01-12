package com.example.calculator_app.events;


import com.example.calculator_app.model.Operator;

public class OperatorEvent extends BaseEvent{

    private final Operator mOperator;

    public OperatorEvent(Operator operator) {
        mOperator = operator;
    }

    public Operator getOperator() {
        return mOperator;
    }
}
