package com.example.ppapav3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class patientLogin extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        Name = (EditText)findViewById(R.id.etPatient);
        Password = (EditText)findViewById(R.id.etPatientPass);
        Info = (TextView)findViewById(R.id.tvIncorrect);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("# of Attempts Remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }
    private void validate(String userName, String userPassword)
    {
        if ((userName.equals("Admin")) && (userPassword.equals("Password")))
        {
            Intent intent = new Intent(patientLogin.this, patientMainPage.class);
            startActivity(intent);
        }
        else
        {
            counter--;
            Info.setText("# of Attempts Remaining: " + String.valueOf(counter));

            if (counter == 0)
            {
                Login.setEnabled(false);
            }
        }
    }


}