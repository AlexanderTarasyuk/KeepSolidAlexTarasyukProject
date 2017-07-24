package com.example.alextarasyuk.keepsolidalextarasyukproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.alextarasyuk.keepsolidalextarasyukproject.fragments.FragmApprove;
import com.example.alextarasyuk.keepsolidalextarasyukproject.fragments.FragmReject;
import com.example.alextarasyuk.keepsolidalextarasyukproject.fragments.FragmentText;


public class MainActivity
        extends AppCompatActivity implements View.OnClickListener {

    //declaring fragments
    private FragmentText textFragment;
    private FragmApprove fragmApprove;
    private FragmReject fragmReject;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Bundle bundle;
    private String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing fragments

        textFragment = new FragmentText();
        fragmApprove = new FragmApprove();
        fragmReject = new FragmReject();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction
                .add(R.id.container, textFragment)
                .commit();

        bundle = new Bundle();
        text = "";

    }
    //logic of pressing buttons

    public void onClick(View view) {

        if (view != null) {
            switch (view.getId()) {
                case R.id.btn_send_frag_text:
                    if (textFragment.getEtText().equals("")) {
                        Toast.makeText(this, "Нет текста", Toast.LENGTH_SHORT).show();
                    } else if (!textFragment.getEtText().contains("@")) {
                        Toast.makeText(this, "Неправильный мейл", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(this, SecondActivity.class);
                        intent.putExtra("text", textFragment.getEtText());
                        startActivityForResult(intent, 1);
                    }
                    break;

                case R.id.btn_clear_frag_text:
                    textFragment.setEtText("");
                    break;

                case R.id.btn_ok_frag_approve:
                    bundle.putString("Status", "Отклонено");
                    bundle.putString("text", text);
                    textFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, textFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .addToBackStack(null)
                            .commit();
                    break;

                case R.id.btn_ok_frag_reject:
                    bundle.putString("Status", "Принято");
                    textFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, textFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .addToBackStack(null)
                            .commit();
                    break;

                default:
                    break;
            }
        }
    }

    //returning result from secondActivity

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fragmentTransaction = fragmentManager.beginTransaction();
        if (data == null) {
            textFragment.setEtText("Error");
            Toast.makeText(this, "Second Activity Error", Toast.LENGTH_SHORT).show();
        } else {
            text = data.getStringExtra("text2");
            if (resultCode == RESULT_CANCELED) {
                fragmentTransaction.replace(R.id.container, fragmReject);
                Toast.makeText(this, "Отклонено", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_OK) {
                fragmentTransaction.replace(R.id.container, fragmApprove);
                Toast.makeText(this, "Принято", Toast.LENGTH_SHORT).show();
                textFragment.setEtText("");
            }

            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
        }
    }
}