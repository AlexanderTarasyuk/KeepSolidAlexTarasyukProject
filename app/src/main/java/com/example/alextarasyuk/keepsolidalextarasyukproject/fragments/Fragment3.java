package com.example.alextarasyuk.keepsolidalextarasyukproject.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alextarasyuk.keepsolidalextarasyukproject.R;


public class Fragment3 extends Fragment {

    //declaring views
    private Button buttonOk;
    private Fragment3Listener fragment3Listener;

    public Fragment3() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflating views
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);
        buttonOk = (Button) view.findViewById(R.id.btn_Ok_fragm2);

        //logic of clicking buttonOk
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDetails3();
            }
        });
        return view;
    }

    public interface Fragment3Listener {
        void onFragmentInteraction3(String str);
    }


    //initializing listener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            fragment3Listener = (Fragment3.Fragment3Listener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    //logic of method updateDetails

    public void updateDetails3() {

        String string = "";
        fragment3Listener.onFragmentInteraction3(string);

    }
}
