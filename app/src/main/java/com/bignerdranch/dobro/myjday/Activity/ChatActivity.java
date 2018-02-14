package com.bignerdranch.dobro.myjday.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bignerdranch.dobro.myjday.R;

/**
 * Created by Dobro on 14.02.2018.
 */

public class ChatActivity extends AppCompatActivity {

    private RecyclerView chatList;
    private EditText messageText;
    private ImageView sendBtn;
    LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);

        messageText = (EditText) findViewById(R.id.edit_message);
        messageText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        sendBtn = (ImageView) findViewById(R.id.image_send);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(messageText.getText() != null && messageText.getText().toString() != ""){

                }
                else {
                    Toast.makeText(getApplicationContext(), "Введите сообщение.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        chatList = (RecyclerView)findViewById(R.id.chat_list);
        chatList.setHasFixedSize(false);
        mLinearLayoutManager = new LinearLayoutManager(this);
        chatList.setLayoutManager(mLinearLayoutManager);

    }
}
