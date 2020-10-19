package com.bookstorage.bookdemo.service.mapper;

import com.bookstorage.bookdemo.entity.UserEntity;
import com.bookstorage.bookdemo.model.UserModel;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class UserMapper implements EntityMapper<UserEntity, UserModel> {
  @Override
  public UserModel convertToDto(UserEntity entity) {
    return null;
  }

  @Override
  public UserEntity convertToEntity(UserModel dto) {
    UserEntity userEntity = new UserEntity();
    userEntity.setUsername(dto.getUsername());
    userEntity.setPassword(dto.getPassword());
    userEntity.setEmail(dto.getEmail());

    Calendar calendar = userEntity.getDob();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String dobString = simpleDateFormat.format(calendar.getTime());

    userEntity.setDob(dobString);

    return userEntity;
  }
}