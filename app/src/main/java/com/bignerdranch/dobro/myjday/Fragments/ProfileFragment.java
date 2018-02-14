package com.bignerdranch.dobro.myjday.Fragments;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.dobro.myjday.Activity.SettingActivity;
import com.bignerdranch.dobro.myjday.Activity.UserPrifileActivity;
import com.bignerdranch.dobro.myjday.R;


/**
 * Created by Dobro on 14.02.2018.
 */

public class ProfileFragment extends Fragment implements View.OnClickListener{

    private View _v;
    private ImageView settingImg, changeImg, userAvatarImg;
    private TextView titleTxt, subtitleTxt, defaultAvatar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        _v = inflater.inflate(R.layout.profile_fragment , container, false);

        settingImg = (ImageView) _v.findViewById(R.id.setting_img);
        changeImg = (ImageView) _v.findViewById(R.id.change);
        settingImg.setOnClickListener(this);
        changeImg.setOnClickListener(this);
        //userAvatarImg = (ImageView) _v.findViewById(R.id.user_avatar);

        titleTxt = (TextView) _v.findViewById(R.id.title);
        subtitleTxt = (TextView) _v.findViewById(R.id.subtitle);
        defaultAvatar = (TextView) _v.findViewById(R.id.default_avatar);

        return _v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.setting_img:
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                getActivity().startActivity(intent);
                break;

            case R.id.change:
                Intent intent1 =  new Intent(getActivity(), UserPrifileActivity.class);
                getActivity().startActivity(intent1);
                break;
            //case R.id.user_avatar:

               // break;
        }
    }
}
