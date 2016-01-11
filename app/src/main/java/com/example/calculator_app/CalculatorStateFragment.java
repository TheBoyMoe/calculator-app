package com.example.calculator_app;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
}
