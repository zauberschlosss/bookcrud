package com.bookstorage.bookdemo.service;

import com.bookstorage.bookdemo.entity.UserEntity;
import com.bookstorage.bookdemo.model.UserModel;
import com.bookstorage.bookdemo.repository.UserRepository;
import com.bookstorage.bookdemo.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public UserEntity saveUser(UserEntity user) {
    return userRepository.save(user);
  }

  @Override
  public UserEntity saveUser(UserModel user) {
    return saveUser(userMapper.convertToEntity(user));
  }

  @Override
  public void deleteUser(UserEntity user) {
    userRepository.delete(user);
  }

  @Override
  public void deleteUserById(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public List<UserEntity> getAllUsers() {
    return (List<UserEntity>) userRepository.findAll();
  }

  @Override
  public void deleteByIds(List<Long> userIds) {
    userRepository.deleteAllByIds(userIds);
  }
}