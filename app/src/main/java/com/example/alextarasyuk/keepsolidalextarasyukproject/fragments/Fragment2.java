package com.example.alextarasyuk.keepsolidalextarasyukproject.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.alextarasyuk.keepsolidalextarasyukproject.MainActivity;
import com.example.alextarasyuk.keepsolidalextarasyukproject.R;


public class Fragment2 extends Fragment {

    public Fragment2() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, null);
        Button buttonOk = (Button) view.findViewById(R.id.btn_Ok_fragm2);
        final TextView textView = (TextView) view.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.chBoxFragment);
        final Button butoonSend = (Button) view.findViewById(R.id.btnSendFragment);


        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText("");
                checkBox.setChecked(false);
                butoonSend.setClickable(false);
                getActivity().
                        getFragmentManager().
                        beginTransaction().
                        replace(R.id.frame_inActivity_forFragment2,
                                getActivity().getFragmentManager().findFragmentById(R.id.fragment1)).
                        addToBackStack(null).
                        commit();


            }
        });
        return view;
    }


}
