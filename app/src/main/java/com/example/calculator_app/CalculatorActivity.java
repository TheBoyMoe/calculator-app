package com.example.calculator_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.calculator_app.events.DisplayEvent;
import com.example.calculator_app.events.NumberEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

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



    @Subscribe
    public void onNumberSelected(NumberEvent event) {
        // when a number event is received, post a DisplayEvent to the bus
        CalculatorApplication.postToBus(new DisplayEvent(event.getNumber()));
    }


    @Override
    protected void onResume() {
        super.onResume();
        getAppBus().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getAppBus().unregister(this);
    }

    private Bus getAppBus() {
        return CalculatorApplication.getInstance().getBus();
    }


}
