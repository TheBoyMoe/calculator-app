package com.example.calculator_app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ButtonsFragment extends Fragment{

    public ButtonsFragment() {}

    public static ButtonsFragment newInstance() {
        return new ButtonsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);

        return view;
    }
}
