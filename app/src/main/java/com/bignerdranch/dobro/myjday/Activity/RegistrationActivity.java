package com.bignerdranch.dobro.myjday.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bignerdranch.dobro.myjday.R;

/**
 * Created by Dobro on 14.02.2018.
 */

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailTxt, loginTxt, passwordTxt, repeatPasswordTxt;
    private Button registrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        emailTxt = (EditText)findViewById(R.id.email_input);
        loginTxt = (EditText)findViewById(R.id.login_input);
        passwordTxt = (EditText)findViewById(R.id.password_input);
        repeatPasswordTxt = (EditText)findViewById(R.id.repeat_password);

        registrationButton = (Button) findViewById(R.id.registration_btn);
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
