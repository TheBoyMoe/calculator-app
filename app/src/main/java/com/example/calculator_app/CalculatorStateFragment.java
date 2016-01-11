package com.example.calculator_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculator_app.events.AppendEvent;
import com.example.calculator_app.events.NumberEvent;
import com.example.calculator_app.events.OperatorEvent;
import com.example.calculator_app.events.SetDisplayEvent;
import com.squareup.otto.Subscribe;

public class CalculatorStateFragment extends BaseFragment{

    private boolean mOperatorWasPressed;

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
    public void onNumberSelected(NumberEvent event) {
        // when a number event is received, check if the operator was pressed prior to this event
        if(mOperatorWasPressed) {
            postToBus(new SetDisplayEvent(event.getNumber()));
        } else {
            postToBus(new AppendEvent(event.getNumber()));
        }
        mOperatorWasPressed = false;
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onOperatorEvent(OperatorEvent event) {
        mOperatorWasPressed = true;
    }



}
