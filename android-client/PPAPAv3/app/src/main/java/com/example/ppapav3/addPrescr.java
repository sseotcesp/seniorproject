package com.example.ppapav3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class addPrescr extends AppCompatActivity {

    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prescr2);

        Back = (Button)findViewById(R.id.btBack);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addPrescr.this, doctorMainPage.class);
                startActivity(intent);
            }
        });
    }

}