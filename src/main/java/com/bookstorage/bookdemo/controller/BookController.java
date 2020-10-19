package com.bookstorage.bookdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

  @RequestMapping("/books")
  public String showBooks() {
    return "books";
  }
}
