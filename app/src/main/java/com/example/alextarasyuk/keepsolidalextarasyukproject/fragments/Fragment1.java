package com.example.alextarasyuk.keepsolidalextarasyukproject.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.alextarasyuk.keepsolidalextarasyukproject.R;
import com.example.alextarasyuk.keepsolidalextarasyukproject.SecondActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener{


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


        btnSend.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        editText.setOnClickListener(this);
        checkBox.setOnClickListener(this);


        return view;

    }

    //logic of pressing buttons is written
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnClearFragment:
                editText.setText("");
                break;
            case R.id.btnSendFragment:
                if (editText.getText().toString().equals("")
                        | !editText.getText().toString().contains("@")
                        | !checkBox.isChecked()) {
                    break;
                }
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("text", editText.getText().toString());
                startActivityForResult(intent, 1);
                break;
        }
    }

    //waiting for result from secondActivity
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        editText.setText(data.getStringExtra("text2"));
    }
}

