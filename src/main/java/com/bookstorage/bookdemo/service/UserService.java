package com.bookstorage.bookdemo.service;

import com.bookstorage.bookdemo.entity.UserEntity;
import com.bookstorage.bookdemo.model.UserModel;

import java.util.List;

public interface UserService {
  UserEntity saveUser(UserEntity user);
  UserEntity saveUser(UserModel user);
  void deleteUser(UserEntity user);
  void deleteUserById(Long id);
  List<UserEntity> getAllUsers();
  void deleteByIds(List<Long> userIds);
}