package com.example.calculator_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    public static final String STATE_FRAGMENT_TAG = "Calculator_state";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        if(getFragmentManager().findFragmentById(R.id.display_fragment_container) == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.display_fragment_container, DisplayFragment.newInstance())
                    .commit();
        }

        if(getFragmentManager().findFragmentById(R.id.buttons_fragment_container) == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.buttons_fragment_container, ButtonsFragment.newInstance())
                    .commit();
        }

        if(getFragmentManager().findFragmentByTag(STATE_FRAGMENT_TAG) == null) {
            getFragmentManager().beginTransaction()
                    .add(CalculatorStateFragment.newInstance(), STATE_FRAGMENT_TAG)
                    .commit();
        }

    }



}
