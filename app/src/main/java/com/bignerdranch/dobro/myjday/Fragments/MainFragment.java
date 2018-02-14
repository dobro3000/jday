package com.bignerdranch.dobro.myjday.Fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.dobro.myjday.Activity.NavigationActivity;
import com.bignerdranch.dobro.myjday.Adapters.UsersAdapter;
import com.bignerdranch.dobro.myjday.Enum.CurrentFragmentType;
import com.bignerdranch.dobro.myjday.Models.UsersModels;
import com.bignerdranch.dobro.myjday.R;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Dobro on 14.02.2018.
 */

public class MainFragment extends Fragment implements View.OnClickListener {

    private View _v;

    private ViewPager mViewPager;
    RecyclerView mRecyclerView;

    private ImageView backImg, nextImg, likeImg, dislikeImg, favoriteImg;
    private UsersAdapter userAdapter;

    private ArrayList<UsersModels> usersArray;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        _v = inflater.inflate(R.layout.fragment_main, container, false);

        mViewPager = (ViewPager) _v.findViewById(R.id.users_list);
        backImg = (ImageView) _v.findViewById(R.id.back);
        nextImg = (ImageView) _v.findViewById(R.id.next);
        likeImg = (ImageView) _v.findViewById(R.id.like);
        dislikeImg = (ImageView) _v.findViewById(R.id.dislike);
        favoriteImg = (ImageView) _v.findViewById(R.id.favorite);
        //mRecyclerView = (RecyclerView)_v.findViewById(R.id.users_list);

        mViewPager.setOnClickListener(this);
        backImg.setOnClickListener(this);
        nextImg.setOnClickListener(this);
        likeImg.setOnClickListener(this);
        dislikeImg.setOnClickListener(this);
        favoriteImg.setOnClickListener(this);

        usersArray = new ArrayList<>();
        usersArray.add(new UsersModels("Паша Седов", "22", "маркетолог"));
        usersArray.add( new UsersModels("Саша Седов", "44", "программист"));
        usersArray.add( new UsersModels("Леша Седов", "22", "преподаватель"));
        usersArray.add(new UsersModels("Миша Седов", "33", "массажист"));

        userAdapter= new UsersAdapter(getActivity(), usersArray);
        mViewPager.setAdapter(userAdapter);


        return _v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                userAdapter.scrollBack();
                break;

            case R.id.next:
                userAdapter.scrollNext();
                break;

            case R.id.like:
                //todo
                break;

            case R.id.dislike:
                //todo
                break;

            case R.id.favorite:
                //todo
                break;

            case R.id.info:
                break;

        }
    }


}
