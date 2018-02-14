package com.bignerdranch.dobro.myjday;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.dobro.myjday.Activity.NavigationActivity;
import com.bignerdranch.dobro.myjday.Activity.RegistrationActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button loginBtn;
    private TextView registrationTxt, fogotenPassTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button) findViewById(R.id.login_btn);
        registrationTxt = (TextView)findViewById(R.id.registration);
        fogotenPassTxt = (TextView) findViewById(R.id.fogotenpass);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(registrationTxt.getText() != "" && fogotenPassTxt.getText() != ""){
                    Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);
                    startActivity(intent);
                }
            }
        });

        registrationTxt.setOnClickListener(this);
        fogotenPassTxt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.registration:
                Intent intent = new Intent(this, RegistrationActivity.class);
                startActivity(intent);
                break;

            case R.id.fogotenpass:
                break;

        }
    }
}
