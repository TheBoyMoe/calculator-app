package com.example.calculator_app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.calculator_app.events.DisplayEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class DisplayFragment extends Fragment{

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

    @SuppressWarnings("unused")
    @Subscribe
    public void onDisplayEvent(DisplayEvent event) {
        mView.setText(event.getValue());
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
