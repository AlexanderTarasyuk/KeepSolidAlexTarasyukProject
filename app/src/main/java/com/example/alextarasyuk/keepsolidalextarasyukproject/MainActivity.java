package com.example.alextarasyuk.keepsolidalextarasyukproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button btnClear;
    private Button btnSend;
    private CheckBox checkBox;
    private String nameFromEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing buttons, edit text, checkbox

        editText = (EditText) findViewById(R.id.editText);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnSend = (Button) findViewById(R.id.btnSend);
        checkBox = (CheckBox) findViewById(R.id.chBox);
//checkBox set checked for convenience
        checkBox.setChecked(true);
// buttons and etc assigned listeners
        btnSend.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        editText.setOnClickListener(this);
        checkBox.setOnClickListener(this);

        nameFromEditText = editText.getText().toString();


    }

    //logic of pressing buttons is written
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnClear:
                editText.setText("");
                break;
            case R.id.btnSend:
                if (editText.getText().toString().equals("")
                        | !editText.getText().toString().contains("@")
                        | !checkBox.isChecked()) {
                    break;
                }
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("text", editText.getText().toString());
                startActivityForResult(intent, 1);
                break;
        }
    }

    //waiting for result from secondActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        editText.setText(data.getStringExtra("text2"));
    }
}
