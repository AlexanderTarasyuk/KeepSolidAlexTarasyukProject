package com.example.alextarasyuk.keepsolidalextarasyukproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.alextarasyuk.keepsolidalextarasyukproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentText extends Fragment {


    //declaring views
    private EditText editText;
    private Button btnClear;
    private Button btnSend;
    private CheckBox checkBox;
    private FragmentManager fragmentManager;
    private Bundle bundle;

    public FragmentText() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_text, container, false);
        editText = view.findViewById(R.id.ed_text_textfrag);
        btnClear = view.findViewById(R.id.btn_clear_frag_text);
        btnSend = view.findViewById(R.id.btn_send_frag_text);
        checkBox = view.findViewById(R.id.ch_box_frag_text);
        fragmentManager = getFragmentManager();

        //view are set listeners
        btnSend.setOnClickListener((View.OnClickListener) this.getActivity());
        btnClear.setOnClickListener((View.OnClickListener) this.getActivity());

        btnSend.setEnabled(true);
        checkBox.setChecked(true);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                btnSend.setEnabled(checkBox.isChecked());
            }
        });

        bundle = this.getArguments();

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (bundle != null) {
            String s = bundle.getString("Status");
            if (s.equalsIgnoreCase("Принято")) {
                editText.setText("");
                checkBox.setChecked(false);
            } else if (s.equalsIgnoreCase("Отклонено")) {
                editText.setText(bundle.getString("text2"));
                checkBox.setChecked(false);
            }
        }
    }

    public String getEtText() {
        return editText.getText().toString();
    }

    public void setEtText(String s) {
        editText.setText(s);
    }
}

