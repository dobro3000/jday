package com.bignerdranch.dobro.myjday.Activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.dobro.myjday.R;

/**
 * Created by Dobro on 14.02.2018.
 */

public class UserPrifileActivity extends AppCompatActivity implements View.OnClickListener{


    TextView aboutTxt, titleUser, subtitleUser;
    EditText aboutImput;
    ImageView editImg, fabBack;
    LinearLayout aboutLine;
    boolean isEdit = true;
    RelativeLayout nicknameLayout, emailLayout, passwordLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prifile_user);

       /* nicknameLayout = (RelativeLayout)findViewById(R.id.layaut_change_nickname);
        nicknameLayout.setOnClickListener(this);
        emailLayout = (RelativeLayout)findViewById(R.id.layout_email);
        emailLayout.setOnClickListener(this);
        passwordLayout = (RelativeLayout)findViewById(R.id.layout_password);
        passwordLayout.setOnClickListener(this);*/

        aboutTxt = (TextView) findViewById(R.id.text_about);
        aboutImput = (EditText)findViewById(R.id.input_about);
        editImg = (ImageView) findViewById(R.id.edit_img);
        aboutLine = (LinearLayout) findViewById(R.id.about_layout);

         editImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (isEdit){
                            isEdit = false;
                            aboutLine.setVisibility(View.VISIBLE);
                            aboutImput.setText(aboutTxt.getText());
                            aboutTxt.setVisibility(View.GONE);
                        }
                        else {
                            isEdit = true;
                            aboutLine.setVisibility(View.GONE);
                            aboutTxt.setText(aboutImput.getText());
                            aboutTxt.setVisibility(View.VISIBLE);
                        }

                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.layaut_change_nickname:
                break;
          /*  case R.id.layout_email:
                break;
            case R.id.layout_password:
                break;*/
            default: break;
        }
    }

    AlertDialog.Builder builder;

    @Override
    protected Dialog onCreateDialog(int id) {
        /*edittext = new EditText(this);
        builder = new AlertDialog.Builder(this);
        switch (id){
            case LANG_ID:

                builder = new AlertDialog.Builder(this);
                builder.setTitle(getResources().getString(R.string.lang)); // заголовок для диалога
                builder.setItems(getResources().getStringArray(R.array.lang), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        SocketHelper.emit(SocketHelper.EVENT_UPDATE_SETTINGS, "{\"language\": \"" + _lang[item].toString() + "\" }", onUpdateSettings);
                    }
                });
                break;
            case KYE_ID:
                builder = new AlertDialog.Builder(this);
                builder.setTitle(getResources().getString(R.string.keyboard)); // заголовок для диалога
                builder.setItems(getResources().getStringArray(R.array.keyboard), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        SocketHelper.emit(SocketHelper.EVENT_UPDATE_SETTINGS, "{\"keyboard\": \"" + "\"" + _keyboard[item].toString() + "\"" + "\" }", onUpdateSettings);
                    }
                });
                break;
            case TEAM_ID:
                builder = new AlertDialog.Builder(this);
                builder.setTitle(getResources().getString(R.string.team)); // заголовок для диалога
                builder.setItems(_team, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        //todo
                    }
                });
                break;

            case NAME_ID:
                builder.setPositiveButton(getResources().getString(R.string.change_result), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (!userName.equals(edittext.getText().toString()) && !edittext.getText().toString().equals("")){
                            SocketHelper.emit(SocketHelper.EVENT_CHANGE_USERNAME, "{\"username\": \"" + edittext.getText().toString() + "\" }", onChangeUserName);
                        }
                        else Toast.makeText(getApplicationContext(), "Некорректное имя.", Toast.LENGTH_SHORT);
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.cancel_result), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // what ever you want to do with No option.
                    }
                });
                return getBaseDialog((getResources().getString(R.string.set_name)), getResources().getString(R.string.change_name));

            case EMAIL_ID:
                edittext.setHint(getResources().getString(R.string.set_email));
                builder.setPositiveButton(getResources().getString(R.string.change_result), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (!email.equals(edittext.getText().toString()) && !edittext.getText().toString().equals("")){
                            SocketHelper.emit(SocketHelper.EVENT_CHANGE_EMAIL, "{\"email\": \"" + edittext.getText().toString() + "\" }", onChangeEmail);
                        }
                        else Toast.makeText(getApplicationContext(), "Некорректный email.", Toast.LENGTH_SHORT);
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.cancel_result), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // what ever you want to do with No option.
                    }
                });
                return getBaseDialog(getResources().getString(R.string.set_email), getResources().getString(R.string.change_email));

            case PASS_ID:
                builder.setPositiveButton(getResources().getString(R.string.change_result), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (!(edittext.getText().toString().contains(" ")) & (edittext.getText().toString().length()>=6) ){
                            SocketHelper.emit(SocketHelper.EVENT_CHANGE_PASSWORD, "{\"password\": \"" + edittext.getText().toString() + "\" }", onChangePassword);
                        }
                        else if (!edittext.getText().toString().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Введите корректный пароль", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.cancel_result), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // what ever you want to do with No option.
                    }
                });
                return getBaseDialog((getResources().getString(R.string.set_pass)), getResources().getString(R.string.change_pass));

        }*/
        return builder.create();
    }
}
