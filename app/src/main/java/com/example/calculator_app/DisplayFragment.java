package com.example.calculator_app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class DisplayFragment extends Fragment{

    public DisplayFragment() {}

    public static DisplayFragment newInstance() {
        return new DisplayFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EditText view = (EditText) inflater.inflate(R.layout.fragment_display, container, false);

        return view;
    }
}
