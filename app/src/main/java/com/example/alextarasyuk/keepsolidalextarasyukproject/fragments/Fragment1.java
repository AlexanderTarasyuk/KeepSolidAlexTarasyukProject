package com.example.alextarasyuk.keepsolidalextarasyukproject.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alextarasyuk.keepsolidalextarasyukproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {


    //declaring views
    private EditText editText;
    private Button btnClear;
    private Button btnSend;
    private CheckBox checkBox;
    private FragmentManager fragmentManager;

    public Fragment1() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false );
        editText = (EditText) view.findViewById(R.id.editTextFragment);
        btnClear = (Button) view.findViewById(R.id.btnClearFragment);
        btnSend = (Button) view.findViewById(R.id.btnSendFragment);
        checkBox = (CheckBox) view.findViewById(R.id.chBoxFragment);
        fragmentManager=getFragmentManager();

        //view are set listeners
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment2 = fragmentManager.findFragmentById(R.id.fragment2);
                fragmentManager.beginTransaction().
                        replace(R.id.frame_inActivity_forFragment1, fragment2)
                        .commit();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment3 = fragmentManager.findFragmentById(R.id.fragment3);
                fragmentManager.beginTransaction().
                        replace(R.id.frame_inActivity_forFragment1, fragment3).
                        commit();
            }
        });

        return view;

    }

    //logic of pressing buttons is written
    @Override
    public void onClick(View view) {

        if (view != null & checkBox.isChecked()) {

            switch (view.getId()) {
                case R.id.btnClearFragment:

                    break;
                case R.id.btnSendFragment:
                    Fragment fragment3 = new Fragment3();
                    getFragmentManager().beginTransaction().
                            replace(R.id.frame_inActivity_forFragment1, fragment3).
                            commit();
                    break;
            }
        }

    }

    //when resumed checkbox is unchecked and buttonSend is unclicable
    @Override
    public void onResume() {
        super.onResume();
        checkBox.setChecked(false);
        btnSend.setClickable(false);
    }

    //waiting for result from secondActivity
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (data == null) {
//            return;
//        }
//        editText.setText(data.getStringExtra("text2"));
//    }

    //method to edit text

    public void editText(String text) {
        TextView view = (TextView) getView().findViewById(R.id.textView);
        view.setText(text);
    }
}

