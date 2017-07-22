package com.example.alextarasyuk.keepsolidalextarasyukproject.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.alextarasyuk.keepsolidalextarasyukproject.R;


public class Fragment2 extends Fragment {

    //declaring views and listener

    private Fragment2Listener fragment2Listener;
    private Button buttonOk;
    private TextView textView;
    private CheckBox checkBox;
    private Button buttonSend;

    public Fragment2() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        buttonOk = (Button) view.findViewById(R.id.btn_Ok_fragm2);
        textView = getActivity().findViewById(R.id.editTextFragment);
        checkBox = getActivity().findViewById(R.id.chBoxFragment);
        buttonSend = getActivity().findViewById(R.id.btnSendFragment);

        //logic of buttonOK

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                textView.setText("");
//                checkBox.setChecked(false);
//                buttonSend.setClickable(false);
//                getActivity().
//                        getFragmentManager().
//                        beginTransaction().
//                        replace(R.id.frame_inActivity_forFragment2,
//                                getActivity().getFragmentManager().findFragmentById(R.id.fragment1)).
//
//                        addToBackStack(null).
//                        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
//                        commit();

                updateDetails();


            }
        });
        return view;
    }

    //interface to interact with another fragments through mainActivity

    public interface Fragment2Listener {
        void onFragmentInteraction(String str);
    }

    //initializing listener

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            fragment2Listener = (Fragment2Listener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    //logic of method updateDetails

    public void updateDetails() {

       String string="";
        fragment2Listener.onFragmentInteraction(string);

    }
}
