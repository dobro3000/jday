package com.bignerdranch.dobro.myjday.Adapters;

import android.app.Activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.dobro.myjday.Activity.AboutUserActivity;
import com.bignerdranch.dobro.myjday.Models.UsersModels;
import com.bignerdranch.dobro.myjday.R;

import java.util.ArrayList;

/**
 * Created by Dobro on 14.02.2018.
 */

public class UsersAdapter extends PagerAdapter {

    private Activity _activity;
    ArrayList<UsersModels> _users;
    private LayoutInflater layoutInflater;
    ViewGroup _container;

    public  UsersAdapter(Activity activity, ArrayList<UsersModels> users){
        _activity = activity;
        this.layoutInflater = (LayoutInflater)activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
        _users = users;

    }

    @Override
    public int getCount() {
        return _users.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }

    public TextView titleTxt, subtitleTxt;
    public ImageView infoImg, imageUser;
    private Integer currentPosition;

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        _container = container;
        View view = this.layoutInflater.inflate(R.layout.item_list_profile, container, false);

        titleTxt = (TextView) view.findViewById(R.id.title_user);
        titleTxt.setText(_users.get(position).getUserName());

        subtitleTxt = (TextView) view.findViewById(R.id.sphere);
        subtitleTxt.setText(_users.get(position).getProfeshionUser());

        currentPosition = position;

        infoImg = (ImageView) view.findViewById(R.id.info);
        infoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrentItem(currentPosition);
            }
        });
        imageUser = (ImageView)view.findViewById(R.id.image_user);

        container.addView(view);
        return view;
    }

    public UsersModels getCurrentItem(Integer position){
        Intent intent = new Intent(_activity, AboutUserActivity.class);
        //intent.putExtra("USER_ID", _users.get(position));
        _activity.startActivity(intent);
        return _users.get(position);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }



    public void scrollBack(){
        if(currentPosition < getCount() - 1){
           // instantiateItem(_container, currentPosition);
        }
        else {
            //todo loadlist
        }
    }

    public void scrollNext(){
        if(currentPosition >= 0){
           // instantiateItem(_container, currentPosition);
        }
        else {
            //todo loadlist
        }
    }
}
