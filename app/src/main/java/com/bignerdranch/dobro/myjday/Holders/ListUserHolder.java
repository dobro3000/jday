package com.bignerdranch.dobro.myjday.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.dobro.myjday.R;

/**
 * Created by Dobro on 14.02.2018.
 */

public class ListUserHolder extends RecyclerView.ViewHolder {

    public TextView titleTxt, subtitleTxt;
    public ImageView infoImg, imageUser;

    public ListUserHolder(View itemView) {
        super(itemView);
        titleTxt = (TextView) itemView.findViewById(R.id.title_user);
        subtitleTxt = (TextView) itemView.findViewById(R.id.sphere);
        infoImg = (ImageView) itemView.findViewById(R.id.info);
        imageUser = (ImageView)itemView.findViewById(R.id.image_user);

    }
}
