package com.example.ppapav3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editPharm extends AppCompatActivity {

    private Button Back;
    private Button CreateP;
    private EditText PharmUser;
    private EditText PharmPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pharm);

        Back = (Button)findViewById(R.id.btBack);
        CreateP = (Button) findViewById(R.id.btCreateP);
        PharmUser = (EditText)findViewById(R.id.etPharmNewUser);
        PharmPass = (EditText)findViewById(R.id.etPatientPassEdit);

        CreateP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(editPharm.this, doctorMainPage.class);
                startActivity(intent);
            }
        });
    }
}