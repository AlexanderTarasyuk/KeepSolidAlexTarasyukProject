package com.example.alextarasyuk.keepsolidalextarasyukproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.alextarasyuk.keepsolidalextarasyukproject.fragments.Fragment1;
import com.example.alextarasyuk.keepsolidalextarasyukproject.fragments.Fragment2;
import com.example.alextarasyuk.keepsolidalextarasyukproject.fragments.Fragment3;


public class MainActivity extends AppCompatActivity implements Fragment2.Fragment2Listener, Fragment3.Fragment3Listener {

    public Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing buttons, edit text, checkbox

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_inActivity_forFragment1, fragment1).
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

    }


    @Override
    public void onFragmentInteraction(String str) {
        Fragment1 fragment1 = new Fragment1();
        fragment1.editText("");
        fragmentManager.beginTransaction().
                replace(R.id.frame_inActivity_forFragment1, fragment1).
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

    }

    @Override
    public void onFragmentInteraction3(String str) {
        Fragment1 fragment1=new Fragment1();
        fragment1.editText(str);

        fragmentManager.beginTransaction().
                replace(R.id.frame_inActivity_forFragment1, fragment1).
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

    }
}
