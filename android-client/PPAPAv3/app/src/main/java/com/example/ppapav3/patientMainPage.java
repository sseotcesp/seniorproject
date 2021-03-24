package com.example.ppapav3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class patientMainPage extends AppCompatActivity {

    private Button Ready;
    private Button LogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_main_page);

        Ready = (Button)findViewById(R.id.btReady2);
        LogOut = (Button)findViewById(R.id.btLO2);

        Ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(patientMainPage.this, patientReady.class);
                startActivity(intent);
            }
        });
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(patientMainPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}