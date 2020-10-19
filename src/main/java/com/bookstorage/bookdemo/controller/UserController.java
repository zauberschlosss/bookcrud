package com.bookstorage.bookdemo.controller;

import com.bookstorage.bookdemo.entity.UserEntity;
import com.bookstorage.bookdemo.model.UserModel;
import com.bookstorage.bookdemo.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

  private final UserServiceImpl userService;

  public UserController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @GetMapping
  public String showUsers(Model model) {
    UserModel userModel = new UserModel();
    model.addAttribute("user", userModel);

    return "users";
  }

  @PostMapping("/createnewuser")
  public String createNewUser(@ModelAttribute("user") UserEntity user, Model model) {
    List<UserEntity> userEntities = userService.getAllUsers();
    model.addAttribute("userEntities", userEntities);
    userService.saveUser(user);

    return "userFormProcessing";
  }

  @GetMapping("/users_table")
  public String getUsersPage(Model model) {
    List<UserEntity> userEntities = userService.getAllUsers();
    model.addAttribute("userEntities", userEntities);

    return "userFormProcessing";
  }

  @PostMapping("/delete_users")
  public String deleteUsers(
      @RequestParam("userIds") List<Long> userIds
  ) {

    userService.deleteByIds(userIds);

    return "userFormProcessing";
  }

  @GetMapping("/get_users")
  public ResponseEntity<?> getUsers() {
    return new ResponseEntity<>(
        userService.getAllUsers(),
        HttpStatus.OK
    );
  }
}