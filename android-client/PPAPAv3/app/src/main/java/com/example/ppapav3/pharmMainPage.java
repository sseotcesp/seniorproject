package com.example.ppapav3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class pharmMainPage extends AppCompatActivity {

    private Button LogOut;
    private TextView Pharmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharm_main_page);

        Pharmer = (TextView)findViewById(R.id.tvPharm);
        LogOut = (Button)findViewById(R.id.btLO3);

        Pharmer.setText("whatever you want to be here");

        Intent intent = getIntent();
        String str = intent.getStringExtra("Username");

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pharmMainPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}