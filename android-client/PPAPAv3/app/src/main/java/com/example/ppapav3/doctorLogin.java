package com.example.ppapav3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.ppapav3.dto.AppResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class doctorLogin extends AppCompatActivity {
    private static String url ="https://cs3zhrwmnc.execute-api.us-east-1.amazonaws.com/APILoginCheck";
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharm_login);

        Name = (EditText)findViewById(R.id.etPatient);
        Password = (EditText)findViewById(R.id.etPatientPass);
        Info = (TextView)findViewById(R.id.tvIncorrect);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("# of Attempts Remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject jsonObj;
                try {
                    jsonObj = new JSONObject();
                    jsonObj.put("user", Name.getText().toString());
                    jsonObj.put("pass", Password.getText().toString());
                    jsonObj.put("role", "DOCTOR");
                } catch (JSONException e){
                    throw new RuntimeException(e);
                }
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.POST, url, jsonObj, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                AppResponse response1 = AppResponse.newInstance(AppResponse.class,  response.toString());
                                if(response1.getStatus() == 1) {
                                    String dUser = Name.getText().toString();
                                    Intent intent = new Intent(doctorLogin.this, doctorMainPage.class);
                                    intent.putExtra("Username", dUser);
                                    startActivity(intent);
                                }
                                else {
                                    counter--;
                                    Info.setText("# of Attempts Remaining: " + String.valueOf(counter));

                                    if (counter == 0)
                                    {
                                        Login.setEnabled(false);
                                    }
                                }
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error

                            }
                        });

                RQueueSingleton.getInstance(getApplicationContext()).getRequestQueue().add(jsonObjectRequest);

            }


        });
    }

}