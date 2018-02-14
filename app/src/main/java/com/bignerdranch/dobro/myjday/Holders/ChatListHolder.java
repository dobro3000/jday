package com.bignerdranch.dobro.myjday.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.dobro.myjday.R;

/**
 * Created by Dobro on 14.02.2018.
 */

public class ChatListHolder extends RecyclerView.ViewHolder {

    public ImageView userAvatar;
    public TextView userName, lastMessage, defaultAvatar;

    public ChatListHolder(View itemView) {
        super(itemView);

        //userAvatar = (ImageView) itemView.findViewById(R.id.user_avatar);
        defaultAvatar = (TextView)itemView.findViewById(R.id.default_avatar);
        userName = (TextView) itemView.findViewById(R.id.user_name);
        lastMessage = (TextView) itemView.findViewById(R.id.lastMessage);
    }
}
