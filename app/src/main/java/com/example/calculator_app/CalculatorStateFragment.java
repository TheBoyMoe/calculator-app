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
    private boolean mOperatorWasPressed;
    private String mOperand  = "";
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
        mOperatorWasPressed = true;
        mOperand = "";
        postToBus(new SetDisplayEvent(event.getOperator()));
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onClearEvent(ClearEvent event) {
        mOperand = "";
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
