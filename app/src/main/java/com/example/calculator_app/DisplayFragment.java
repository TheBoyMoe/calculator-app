package com.example.calculator_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.calculator_app.events.DisplayEvent;
import com.example.calculator_app.events.OperatorEvent;
import com.squareup.otto.Subscribe;

public class DisplayFragment extends BaseFragment{

    private EditText mView;

    public DisplayFragment() {}

    public static DisplayFragment newInstance() {
        return new DisplayFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = (EditText) inflater.inflate(R.layout.fragment_display, container, false);

        return mView;
    }

    // registering/unregistering the bus are handled in the base fragment
    @SuppressWarnings("unused")
    @Subscribe
    public void onOperatorDisplay(OperatorEvent event) {
        mView.setText(event.getOperator());
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onDisplayEvent(DisplayEvent event) {
        mView.setText(event.getValue());
    }


}
