package com.example.calculator_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculator_app.events.DisplayEvent;
import com.example.calculator_app.events.NumberEvent;
import com.squareup.otto.Subscribe;

public class CalculatorStateFragment extends BaseFragment{

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
        // when a number event is received, post a DisplayEvent to the bus
        postToBus(new DisplayEvent(event.getNumber()));
    }



}
