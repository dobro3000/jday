package com.bignerdranch.dobro.myjday.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.dobro.myjday.Holders.ChatListHolder;
import com.bignerdranch.dobro.myjday.Models.ChatListModel;
import com.bignerdranch.dobro.myjday.R;

import java.util.ArrayList;

/**
 * Created by Dobro on 14.02.2018.
 */

public class ChatListAdapter extends RecyclerView.Adapter<ChatListHolder> implements   RecyclerView.OnItemTouchListener {

    Activity _activity;
    ArrayList<ChatListModel> _chatListModel;
    View _v;
    ViewGroup _parent;


    public ChatListAdapter(Activity activity, ArrayList<ChatListModel> chatListModels){
        _chatListModel = chatListModels;
        _activity = activity;
    }

    @Override
    public ChatListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        _v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_chat, parent, false);
        final ChatListHolder viewHolder = new ChatListHolder(_v);
        _parent = parent;
        return viewHolder;
    }


    //для реализации событий на клик
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
        public void onLongItemClick(View view, int position);
    }

    @Override
    public void onBindViewHolder(ChatListHolder holder, int position) {
        holder.userName.setText(_chatListModel.get(position).getUserName());
        holder.lastMessage.setText(_chatListModel.get(position).getLastPing());
    }

    @Override
    public int getItemCount() {
        return _chatListModel.size();
    }

    public ChatListAdapter.OnItemClickListener _listener;
    GestureDetector mGestureDetector;

    public ChatListAdapter(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
        _listener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && _listener != null) {
                    _listener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View childView = rv.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && _listener != null && mGestureDetector.onTouchEvent(e)) {
            try
            {
                _listener.onItemClick(childView, rv.getChildAdapterPosition(childView));
            }
            catch (Exception exc){
                exc.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
