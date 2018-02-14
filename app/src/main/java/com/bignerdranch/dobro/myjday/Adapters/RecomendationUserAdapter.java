package com.bignerdranch.dobro.myjday.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.dobro.myjday.Holders.ChatListHolder;
import com.bignerdranch.dobro.myjday.Models.ChatListModel;
import com.bignerdranch.dobro.myjday.R;

import java.util.ArrayList;

/**
 * Created by Dobro on 14.02.2018.
 */

public class RecomendationUserAdapter extends RecyclerView.Adapter<ChatListHolder> {


    Activity _activity;
    ArrayList<ChatListModel> _chatListModel;
    View _v;
    ViewGroup _parent;


    public RecomendationUserAdapter(Activity activity, ArrayList<ChatListModel> chatListModels){
        _chatListModel = chatListModels;
        _activity = activity;
    }

    @Override
    public ChatListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        _v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_chat, parent, false);
        final ChatListHolder viewHolder = new ChatListHolder(_v);
        _parent = parent;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChatListHolder holder, int position) {
      /*  holder.userName.setVisibility(View.GONE);
        holder.lastMessage.setVisibility(View.GONE);*/
    }

    @Override
    public int getItemCount() {
        return _chatListModel.size();
    }
}
