package com.example.calculator_app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ButtonsFragment extends Fragment implements View.OnClickListener{

    private Button mButtonOne;

    public ButtonsFragment() {}

    public static ButtonsFragment newInstance() {
        return new ButtonsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);

        mButtonOne = (Button) view.findViewById(R.id.button_one);
        mButtonOne.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button_one)
            Toast.makeText(getActivity(), mButtonOne.getText(), Toast.LENGTH_SHORT).show();
    }


}
