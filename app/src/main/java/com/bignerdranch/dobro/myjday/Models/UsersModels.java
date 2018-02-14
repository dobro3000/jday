package com.bignerdranch.dobro.myjday.Models;

/**
 * Created by Dobro on 14.02.2018.
 */

public class UsersModels {

    public UsersModels(String nameUser, String ageUser, String profeshion){
        setUserName(nameUser);
        setAgeUser(ageUser);
        setProfeshionUser(profeshion);
    }

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String ageUser;

    public String getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(String ageUser) {
        this.ageUser = ageUser;
    }

    private String profeshionUser;

    public String getProfeshionUser() {
        return profeshionUser;
    }

    public void setProfeshionUser(String profeshionUser) {
        this.profeshionUser = profeshionUser;
    }
}
