package com.bookstorage.bookdemo.model;

import java.util.Calendar;

public class UserModel {
  private String username;
  private String password;
  private String email;
  private Calendar dob;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Calendar getDob() {
    return dob;
  }

  public void setDob(Calendar dob) {
    this.dob = dob;
  }
}