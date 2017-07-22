package com.example.alextarasyuk.keepsolidalextarasyukproject;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.alextarasyuk.keepsolidalextarasyukproject.fragments.Fragment1;
import com.example.alextarasyuk.keepsolidalextarasyukproject.fragments.Fragment2;
import com.example.alextarasyuk.keepsolidalextarasyukproject.fragments.Fragment3;


public class MainActivity
        extends Activity
        implements Fragment2.Fragment2Listener, Fragment3.Fragment3Listener {

    //declaring fragments
    private Fragment1 fragment1;
    private Fragment fragment2;
    private Fragment fragment3;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing fragments
        fragmentManager = getFragmentManager();
        Fragment fragment1 = (Fragment1) fragmentManager.findFragmentById(R.id.fragment1);
        fragmentManager
                .beginTransaction()
                .add(R.id.frame_inActivity_forFragment1, fragment1)
                .commit();
    }

    @Override
    public void onFragmentInteraction(String str) {


        fragment1.editText("");
        fragmentManager.beginTransaction().
                replace(R.id.frame_inActivity_forFragment1, fragment1)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

    }

    @Override
    public void onFragmentInteraction3(String str) {

        fragment1.editText(str);

        fragmentManager.beginTransaction()
                .replace(R.id.frame_inActivity_forFragment1, fragment1)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

    }
}
