package com.example.alextarasyuk.keepsolidalextarasyukproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    //declaring views of activity

    private TextView textView;
    private Button buttonApprove;
    private Button buttonReject;
    private String nameToPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //initializing buttons and textView
        textView = (TextView) findViewById(R.id.text_view);
        buttonApprove = (Button) findViewById(R.id.btn_approve);
        buttonReject = (Button) findViewById(R.id.btn_reject);
        nameToPrint="";

        //buttons assigned listeners
        buttonApprove.setOnClickListener(this);
        buttonReject.setOnClickListener(this);

        //textView is getting text from mainActivity
        if (!TextUtils.isEmpty(getIntent().getStringExtra("text"))) {
            nameToPrint = getIntent().getStringExtra("text");
            textView.setText(nameToPrint);
        }
    }

    //logic of pressing buttons
    @Override
    public void onClick(View view) {

        if (view!=null) {

            switch (view.getId()) {
                case R.id.btn_approve:
                    Intent intent = new Intent();
                    intent.putExtra("text2", textView.getText().toString());
                    Toast.makeText(SecondActivity.this, "Посылаю имейл", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK, intent);
                    finish();
                    break;

                case R.id.btn_reject:
                    Intent intent2 = new Intent();
                    intent2.putExtra("text2", textView.getText().toString());
                    setResult(RESULT_CANCELED, intent2);
                    finish();
                    break;
            }
        }
    }
}
