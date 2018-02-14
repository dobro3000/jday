package com.bignerdranch.dobro.myjday.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.dobro.myjday.R;

/**
 * Created by Dobro on 14.02.2018.
 */

public class ChatHolder extends RecyclerView.ViewHolder {

    public TextView message;
    public ImageView image;

    public ChatHolder(View itemView) {
        super(itemView);

        message = itemView.findViewById(R.id.user_message);
    }
}
