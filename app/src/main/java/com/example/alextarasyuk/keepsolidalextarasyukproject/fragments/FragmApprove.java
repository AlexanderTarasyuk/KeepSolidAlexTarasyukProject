package com.example.alextarasyuk.keepsolidalextarasyukproject.fragments;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alextarasyuk.keepsolidalextarasyukproject.MainActivity;
import com.example.alextarasyuk.keepsolidalextarasyukproject.R;


public class FragmApprove extends Fragment {

    //declaring views and listener

    private Button btnOkFragApprove;


    public FragmApprove() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragm_approve, container, false);
        btnOkFragApprove = view.findViewById(R.id.btn_ok_frag_approve);

        //logic of buttonOK


        if (getActivity() instanceof MainActivity) {
            btnOkFragApprove.setOnClickListener((View.OnClickListener) getActivity());
        }

        return view;
    }

}
