package com.bignerdranch.dobro.myjday.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bignerdranch.dobro.myjday.R;

/**
 * Created by Dobro on 14.02.2018.
 */

public class AboutUserActivity extends AppCompatActivity {

    TextView aboutTxt, titleUser, subtitleUser;
    EditText aboutImput;
    ImageView editImg, fabBack;
    LinearLayout aboutLine;
    boolean isEdit = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_activity);

        ActionBar bar = this.getSupportActionBar();
        bar.setHomeButtonEnabled(true);
        bar.setDisplayHomeAsUpEnabled(true);

        aboutTxt = (TextView) findViewById(R.id.text_about);
        aboutImput = (EditText)findViewById(R.id.input_about);
        editImg = (ImageView) findViewById(R.id.edit_img);
        titleUser = (TextView) findViewById(R.id.title_user);
        subtitleUser = (TextView) findViewById(R.id.subtitle_user);
        aboutLine = (LinearLayout) findViewById(R.id.about_layout);
        fabBack = (ImageView) findViewById(R.id.fab_change);

        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
