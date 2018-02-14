package com.bignerdranch.dobro.myjday.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bignerdranch.dobro.myjday.Adapters.ChatAdapter;
import com.bignerdranch.dobro.myjday.Models.ChatListModel;
import com.bignerdranch.dobro.myjday.Models.ChatModel;
import com.bignerdranch.dobro.myjday.R;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by Dobro on 14.02.2018.
 */

public class ChatActivity extends AppCompatActivity {

    private RecyclerView chatList;
    private EditText messageText;
    private ImageView sendBtn;
    LinearLayoutManager mLinearLayoutManager;
    ArrayList<ChatModel> chatModelArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



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

        chatModelArray = new ArrayList<>();
        chatModelArray.add(new ChatModel("Привет" , 1));
        chatModelArray.add( new ChatModel("Привет!",0));
        chatModelArray.add( new ChatModel("Че как?",  1));
        chatModelArray.add(new ChatModel("Норм",  0));

        ChatAdapter chatAdapter = new ChatAdapter(this, chatModelArray);
        chatList.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();

    }
}
