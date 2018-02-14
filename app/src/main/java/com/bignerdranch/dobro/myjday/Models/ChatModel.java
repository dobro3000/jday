package com.bignerdranch.dobro.myjday.Models;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Dobro on 14.02.2018.
 */

public class ChatModel  {


   public ChatModel(String lastMessage, Integer userId){
      setUserId(userId);
      setMessage(lastMessage);
   }

   private  Integer userId;

   public Integer getUserId() {
      return userId;
   }

   private String message;

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public void setUserId(Integer userId) {
      this.userId = userId;
   }
}
