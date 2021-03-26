package com.example.ppapav3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class doctorEdit extends AppCompatActivity {

    private EditText PUser;
    private EditText PPass;
    private EditText Date1;
    private EditText Date2;
    private EditText Date3;
    private EditText Time1;
    private EditText Time2;
    private EditText Time3;
    private Button Back;
    private Button CreatePA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_edit);

        CreatePA = (Button)findViewById(R.id.btCreatePA);
        Back = (Button)findViewById(R.id.btBack);
        PUser = (EditText)findViewById(R.id.etPharmNewUser);
        PPass = (EditText)findViewById(R.id.etPatientPassEdit);
        Date1 = (EditText)findViewById(R.id.etDate1);
        Date2 = (EditText)findViewById(R.id.etDate2);
        Date3 = (EditText)findViewById(R.id.etDate3);
        Time1 = (EditText)findViewById(R.id.etTime1);
        Time2 = (EditText)findViewById(R.id.etTime2);
        Time3 = (EditText)findViewById(R.id.etTime3);

        CreatePA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(doctorEdit.this, doctorMainPage.class);
                startActivity(intent);
            }
        });
    }
}