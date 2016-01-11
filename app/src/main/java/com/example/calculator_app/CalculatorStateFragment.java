package com.example.calculator_app;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculator_app.events.DisplayEvent;
import com.example.calculator_app.events.NumberEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class CalculatorStateFragment extends Fragment{

    public CalculatorStateFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    public static CalculatorStateFragment newInstance() {
        return new CalculatorStateFragment();
    }


    @SuppressWarnings("unused")
    @Subscribe
    public void onNumberSelected(NumberEvent event) {
        // when a number event is received, post a DisplayEvent to the bus
        CalculatorApplication.postToBus(new DisplayEvent(event.getNumber()));
    }


    @Override
    public void onResume() {
        super.onResume();
        getAppBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getAppBus().unregister(this);
    }

    private Bus getAppBus() {
        return CalculatorApplication.getInstance().getBus();
    }



}
