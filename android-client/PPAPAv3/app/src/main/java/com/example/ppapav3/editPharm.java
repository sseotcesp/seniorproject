package com.example.ppapav3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class editPharm extends AppCompatActivity {

    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pharm);

        Back = (Button)findViewById(R.id.btBack);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(editPharm.this, doctorMainPage.class);
                startActivity(intent);
            }
        });
    }
}