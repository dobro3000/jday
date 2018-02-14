package com.bignerdranch.dobro.myjday.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.dobro.myjday.Activity.ChatActivity;
import com.bignerdranch.dobro.myjday.Adapters.ChatListAdapter;
import com.bignerdranch.dobro.myjday.Adapters.RecomendationUserAdapter;
import com.bignerdranch.dobro.myjday.Models.ChatListModel;
import com.bignerdranch.dobro.myjday.Models.UsersModels;
import com.bignerdranch.dobro.myjday.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Dobro on 14.02.2018.
 */

public class ChatListFragment extends Fragment {

    private View _v;
    private RecyclerView chatList, usersList;
    LinearLayoutManager mLinearLayoutManager;
    LinearLayoutManager mLinearLayoutManage2;

    ArrayList<ChatListModel> chatListModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        _v = inflater.inflate(R.layout.chat_fragment, container, false);

        chatList = (RecyclerView)_v.findViewById(R.id.chat_list);
        chatList.setHasFixedSize(false);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        chatList.setLayoutManager(mLinearLayoutManager);

        chatListModel = new ArrayList<>();
        chatListModel.add(new ChatListModel("Паша Седов", "22", "маркетолог"));
        chatListModel.add( new ChatListModel("Саша Седов", "44", "программист"));
        chatListModel.add( new ChatListModel("Леша Седов", "22", "преподаватель"));
        chatListModel.add(new ChatListModel("Миша Седов", "33", "массажист"));

        usersList = (RecyclerView) _v.findViewById(R.id.users_list);

        ChatListAdapter adapter = new ChatListAdapter(getActivity(), chatListModel);
        chatList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        RecomendationUserAdapter adapter1 = new RecomendationUserAdapter(getActivity(), chatListModel);
        usersList.setAdapter(adapter1);
        usersList.setHasFixedSize(true);
        mLinearLayoutManage2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        usersList.setLayoutManager(mLinearLayoutManage2);
        adapter1.notifyDataSetChanged();

        chatList.addOnItemTouchListener(
                new ChatListAdapter(getActivity(), chatList ,new ChatListAdapter.OnItemClickListener() {
                    @Override public void onItemClick(View view,final int position) {
                        Intent intent = new Intent(getActivity(), ChatActivity.class);
                        getActivity().startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        return _v;
    }
}
