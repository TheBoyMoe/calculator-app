package com.example.calculator_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

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

    }


}
