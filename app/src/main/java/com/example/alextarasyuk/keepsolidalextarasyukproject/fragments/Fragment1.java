package com.example.alextarasyuk.keepsolidalextarasyukproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.alextarasyuk.keepsolidalextarasyukproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


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
        View view= inflater.inflate(R.layout.fragment_fragment1, null);
        editText = (EditText)view.findViewById(R.id.editTextFragment);
        btnClear = (Button) view.findViewById(R.id.btnClearFragment);
        btnSend = (Button) view.findViewById(R.id.btnSendFragment);
        checkBox = (CheckBox) view.findViewById(R.id.chBoxFragment);
//checkBox set checked for convenience
        checkBox.setChecked(true);
        return view;

    }
}
