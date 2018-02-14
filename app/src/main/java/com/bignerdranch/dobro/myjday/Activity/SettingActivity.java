package com.bignerdranch.dobro.myjday.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.bignerdranch.dobro.myjday.R;

/**
 * Created by Dobro on 14.02.2018.
 */

public class SettingActivity extends AppCompatActivity {

    SeekBar seekAge, seekSphere;
    TextView exitTxt, communicationTxt;
    RelativeLayout superlike, mentorNotify, messageNotify;
    Switch superLikeSwith, mentorRequestSwith, messageNotifitySwith, swithAll, swithSphere;
    TextView ageTxt, stageTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);

        ActionBar bar = this.getSupportActionBar();
        bar.setHomeButtonEnabled(true);

        ageTxt = (TextView) findViewById(R.id.age_value);
        stageTxt = (TextView) findViewById(R.id.age_stage);
        swithAll = (Switch) findViewById(R.id.switch_all);
        swithSphere = (Switch) findViewById(R.id.switch_sphere);
        seekAge = (SeekBar) findViewById(R.id.seek_age);
        seekSphere = (SeekBar) findViewById(R.id.stage);
        messageNotifitySwith = (Switch) findViewById(R.id.message_notify);
        mentorRequestSwith = (Switch) findViewById(R.id.mentor_request);
        superLikeSwith = (Switch) findViewById(R.id.switch_superlike);
        communicationTxt = (TextView) findViewById(R.id.communication);
        exitTxt = (TextView) findViewById(R.id.exit_btn);

        messageNotify = (RelativeLayout) findViewById(R.id.notification_message);
        superlike = (RelativeLayout) findViewById(R.id.notification_superlike);
        mentorNotify = (RelativeLayout) findViewById(R.id.notification_mentorequest);


    }

}
