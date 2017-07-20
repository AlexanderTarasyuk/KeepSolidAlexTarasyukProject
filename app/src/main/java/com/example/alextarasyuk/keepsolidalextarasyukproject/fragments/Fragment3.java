package com.example.alextarasyuk.keepsolidalextarasyukproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.alextarasyuk.keepsolidalextarasyukproject.R;


public class Fragment3 extends Fragment {

    public Fragment3() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment3, null);
        Button buttonOk = (Button) view.findViewById(R.id.btn_Ok_fragm2);
        final CheckBox checkBox=getActivity().findViewById(R.id.chBoxFragment);
        final Button butoonSend=getActivity().findViewById(R.id.btnSendFragment);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkBox.setChecked(false);
                butoonSend.setClickable(false);

                getActivity().
                getFragmentManager().
                        beginTransaction().
                        replace(R.id.frame_inActivity_forFragment3,
                                getActivity().getFragmentManager().findFragmentById(R.id.fragment1)).
                        addToBackStack(null).
                        commit();
            }
        });
        return view;
    }


}

