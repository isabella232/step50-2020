package com.google.sps.servlets;

import java.util.List;
import java.util.ArrayList;

public class User{
  String email;
  long userID;
  
  User(String email, long userID) {
    this.email = email;
    this.userID = userID;
  }

  public long getUserID() {
    return userID;
  }
}