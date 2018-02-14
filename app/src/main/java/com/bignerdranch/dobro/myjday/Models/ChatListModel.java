package com.bignerdranch.dobro.myjday.Models;

/**
 * Created by Dobro on 14.02.2018.
 */

public class ChatListModel {

    public ChatListModel(String userName, String lastPing, String lastMessage){
        setUserName(userName);
        setLastPing(lastPing);
        setLastMessage(lastMessage);
    }

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String lastPing;

    public String getLastPing() {
        return lastPing;
    }

    public void setLastPing(String lastPing) {
        this.lastPing = lastPing;
    }

    private String lastMessage;

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
