package com.google.sps.models;

import java.util.List;
import java.util.ArrayList;

public class User{
  String email, nickname;
  long userID;
  
  User(String email, String nickname, long userID) {
    this.email = email;
    this.nickname = nickname;
    this.userID = userID;
  }

  public long getUserID() {
    return userID;
  }

  public String getNickname() {
    return nickname;
  }
 
  public String getEmail() {
    return email;
  }
}