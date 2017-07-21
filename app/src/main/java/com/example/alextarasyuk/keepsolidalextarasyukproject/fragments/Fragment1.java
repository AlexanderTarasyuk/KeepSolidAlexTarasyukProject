package com.example.alextarasyuk.keepsolidalextarasyukproject.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alextarasyuk.keepsolidalextarasyukproject.R;
import com.example.alextarasyuk.keepsolidalextarasyukproject.SecondActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {


    private EditText editText;
    private Button btnClear;
    private Button btnSend;
    private CheckBox checkBox;

    public Fragment1() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, null);
        editText = (EditText) view.findViewById(R.id.editTextFragment);
        btnClear = (Button) view.findViewById(R.id.btnClearFragment);
        btnSend = (Button) view.findViewById(R.id.btnSendFragment);
        checkBox = (CheckBox) view.findViewById(R.id.chBoxFragment);


        btnSend.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        editText.setOnClickListener(this);
        checkBox.setOnClickListener(this);


        return view;

    }

    //logic of pressing buttons is written
    @Override
    public void onClick(View view) {

        if(view!=null &checkBox.isChecked()) {

            switch (view.getId()) {
                case R.id.btnClearFragment:
                    Fragment2 fragment2 = new Fragment2();
                    getFragmentManager().beginTransaction().
                            replace(R.id.frame_inActivity_forFragment1, fragment2).
                            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
                    break;
                case R.id.btnSendFragment:
                    Fragment3 fragment3 = new Fragment3();
                    getFragmentManager().beginTransaction().
                            replace(R.id.frame_inActivity_forFragment1, fragment3).
                            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
                            commit();
                    break;
            }
        }

    }


    @Override
    public void onResume() {
        super.onResume();
        checkBox.setChecked(false);
        btnSend.setClickable(false);
    }

    //waiting for result from secondActivity
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        editText.setText(data.getStringExtra("text2"));
    }

    public void editText(String text) {
        TextView view = (TextView) getView().findViewById(R.id.textView);
        view.setText(text);
    }
}

