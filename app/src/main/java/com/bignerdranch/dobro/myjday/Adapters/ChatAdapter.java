package com.bignerdranch.dobro.myjday.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.dobro.myjday.Holders.ChatHolder;
import com.bignerdranch.dobro.myjday.Models.ChatModel;
import com.bignerdranch.dobro.myjday.R;

import java.util.ArrayList;

/**
 * Created by Dobro on 14.02.2018.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatHolder>{

    private ArrayList<ChatModel> _chatArray;
    private Activity _activity;
    Integer _myId = 0;
    final Integer VIEW_TYPE_FORIN = 0;
    final Integer VIEW_TYPE_ME = 1;
    private View _v;
    private LayoutInflater _layoutInflater;
    private ViewGroup _parent;


    public ChatAdapter(Activity activity, ArrayList<ChatModel> chatArray){
        _activity = activity;
        _chatArray = new ArrayList<>(chatArray);
        _layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public int getItemViewType(int position) {

        return _chatArray.get(position).getUserId() == _myId
                ? VIEW_TYPE_ME
                : VIEW_TYPE_FORIN;
    }

    @Override
    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId;
        if(viewType == VIEW_TYPE_ME){
            layoutId =  R.layout.item_chat_me;
        }
        else {
            layoutId = R.layout.item_chat_for;
        }

        _v = LayoutInflater.from(parent.getContext()).inflate(layoutId, _parent, false);
        final ChatHolder viewHolder = new ChatHolder(_v);
        _parent = parent;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChatHolder holder, int position) {
        holder.message.setText(_chatArray.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return _chatArray.size();
    }
}
