package com.example.ppapav3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class doctorMainPage extends AppCompatActivity {

    private Button Ready;
    private Button LogOut;
    private Button EditPatient;
    private Button EditPharm;
    private Button AddPresc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main_page);

        Ready = (Button)findViewById(R.id.btReady);
        LogOut = (Button)findViewById(R.id.btLO);
        EditPatient = (Button)findViewById(R.id.btEditPatient);
        EditPharm = (Button)findViewById(R.id.btEditPharm);
        AddPresc = (Button)findViewById(R.id.btAddPresc);

        Ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(doctorMainPage.this, doctorReady.class);
                startActivity(intent);
            }
        });
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(doctorMainPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
        EditPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(doctorMainPage.this, doctorEdit.class);
                startActivity(intent);
            }
        });
        EditPharm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(doctorMainPage.this, editPharm.class);
                startActivity(intent);
            }
        });
        AddPresc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(doctorMainPage.this, addPrescr.class);
                startActivity(intent);
            }
        });
    }

}