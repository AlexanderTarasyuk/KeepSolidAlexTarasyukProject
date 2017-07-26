package com.example.alextarasyuk.keepsolidalextarasyukproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alextarasyuk.keepsolidalextarasyukproject.MainActivity;
import com.example.alextarasyuk.keepsolidalextarasyukproject.R;


public class FragmReject extends Fragment {

    //declaring views
    private Button btnOkFragReject;

    public FragmReject() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflating views
        View view = inflater.inflate(R.layout.fragm_reject, container, false);
        btnOkFragReject = (Button) view.findViewById(R.id.btn_ok_frag_reject);

        //logic of clicking buttonOk

        if (getActivity() instanceof MainActivity) {
            btnOkFragReject.setOnClickListener((View.OnClickListener) getActivity());
        }
        return view;
    }
}
