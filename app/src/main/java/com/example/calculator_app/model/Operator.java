package com.example.calculator_app.model;

public enum Operator {

    NONE(""),
    MODULO("%"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MINUS("-"),
    PLUS("+");

    private String mOperatorString;

    Operator(String operatorString) {
        mOperatorString = operatorString;
    }

    public String getOperatorString() {
        return mOperatorString;
    }
}
