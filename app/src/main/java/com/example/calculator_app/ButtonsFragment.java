package com.example.calculator_app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.calculator_app.events.NumberEvent;

public class ButtonsFragment extends Fragment{


    private View mView;

    public ButtonsFragment() {}

    public static ButtonsFragment newInstance() {
        return new ButtonsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_buttons, container, false);
        configureNumberButtons();
        configureOperatorButtons();
        confingureEqualsButton();
        configureClearButton();
        return mView;
    }

    private void configureClearButton() {
        findAndSetClearButtonOnClickListener(R.id.button_clear);
    }

    private void confingureEqualsButton() {
        findAndSetEqualsButtonOnClickListener(R.id.button_equals);
    }

    private void configureOperatorButtons() {
        findAndSetOperatorButtonOnClickListener(R.id.button_plus);
        findAndSetOperatorButtonOnClickListener(R.id.button_minus);
        findAndSetOperatorButtonOnClickListener(R.id.button_multiply);
        findAndSetOperatorButtonOnClickListener(R.id.button_divide);
        findAndSetOperatorButtonOnClickListener(R.id.button_modulus);

    }

    private void configureNumberButtons() {
        findAndSetNumberButtonOnClickListener(R.id.button_one);
        findAndSetNumberButtonOnClickListener(R.id.button_two);
        findAndSetNumberButtonOnClickListener(R.id.button_three);
        findAndSetNumberButtonOnClickListener(R.id.button_four);
        findAndSetNumberButtonOnClickListener(R.id.button_five);
        findAndSetNumberButtonOnClickListener(R.id.button_six);
        findAndSetNumberButtonOnClickListener(R.id.button_seven);
        findAndSetNumberButtonOnClickListener(R.id.button_eight);
        findAndSetNumberButtonOnClickListener(R.id.button_nine);
        findAndSetNumberButtonOnClickListener(R.id.button_zero);
    }

    private void findAndSetClearButtonOnClickListener(int id) {
        mView.findViewById(id).setOnClickListener(createClearButtonListener());
    }

    private void findAndSetEqualsButtonOnClickListener(int id) {
        mView.findViewById(id).setOnClickListener(createEqualsButtonListener());
    }

    private void findAndSetOperatorButtonOnClickListener(int id) {
        mView.findViewById(id).setOnClickListener(createOperatorButtonListener());
    }

    private void findAndSetNumberButtonOnClickListener(int id) {
        mView.findViewById(id).setOnClickListener(createNumberButtonListener());
    }

    private View.OnClickListener createClearButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), ((Button)view).getText(),
                        Toast.LENGTH_SHORT).show();
            }
        };
    }

    private View.OnClickListener createEqualsButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), ((Button)view).getText(),
                        Toast.LENGTH_SHORT).show();
            }
        };
    }

    private View.OnClickListener createOperatorButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), ((Button)view).getText(),
                        Toast.LENGTH_SHORT).show();
            }
        };
    }

    private View.OnClickListener createNumberButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = ((Button)view).getText().toString();
                CalculatorApplication.postToBus(new NumberEvent(number));
            }
        };
    }

}
