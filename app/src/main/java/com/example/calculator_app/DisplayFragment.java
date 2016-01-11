package com.example.calculator_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.calculator_app.events.AppendEvent;
import com.example.calculator_app.events.SetDisplayEvent;
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


    @SuppressWarnings("unused")
    @Subscribe
    public void onAppendDisplay(AppendEvent event) {
        // retrieve the current display string and append the event string
        setDisplay(getDisplayString() + event.getValue());
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onSetDisplay(SetDisplayEvent event) {
        setDisplay(event.getValue());
    }

    public String getDisplayString() {
        return mView.getText().toString();
    }

    private void setDisplay(String string) {
        mView.setText(string);
    }


}
