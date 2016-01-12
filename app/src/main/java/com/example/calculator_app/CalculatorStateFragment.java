package com.example.calculator_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculator_app.events.AppendEvent;
import com.example.calculator_app.events.ClearEvent;
import com.example.calculator_app.events.NumberEvent;
import com.example.calculator_app.events.OperatorEvent;
import com.example.calculator_app.events.SetDisplayEvent;
import com.example.calculator_app.model.Operator;
import com.squareup.otto.Subscribe;

public class CalculatorStateFragment extends BaseFragment{

    public static final int MAX_OPERAND_LENGTH = 10;
    public static final String DEFAULT_OPERAND = "";
    private boolean mOperatorWasPressed;
    private String mOperand  = DEFAULT_OPERAND;
    private Operator mOperator = Operator.NONE;

    public CalculatorStateFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    public static CalculatorStateFragment newInstance() {
        return new CalculatorStateFragment();
    }


    // registering/unregistering and posting to the bus are handled by the BaseFragment
    @SuppressWarnings("unused")
    @Subscribe
    public void onNumberEvent(NumberEvent event) {
        if(maxOperatorLimitReached())
            return;

        // when a number event is received, check if the operator was pressed prior to this event
        if(mOperatorWasPressed) {
            postToBus(new SetDisplayEvent(event.getNumber()));
        } else {
            postToBus(new AppendEvent(event.getNumber()));
        }
        mOperand += event.getNumber();
        mOperatorWasPressed = false;
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onOperatorEvent(OperatorEvent event) {
        if(noNumberEntered()) {
            return;
        }
        mOperatorWasPressed = true;
        mOperand = DEFAULT_OPERAND;
        mOperator = event.getOperator();
        postToBus(new SetDisplayEvent(event.getOperator().getOperatorString()));
    }

    private boolean noNumberEntered() {
        return mOperator == Operator.NONE && mOperand.equals(DEFAULT_OPERAND);
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onClearEvent(ClearEvent event) {
        mOperand = DEFAULT_OPERAND;
        mOperator = Operator.NONE;
    }


    public String getOperand() {
        return mOperand;
    }

    private boolean maxOperatorLimitReached() {
        return mOperand.length() >= MAX_OPERAND_LENGTH;
    }

    public Operator getOperator() {
        return mOperator;
    }


}
