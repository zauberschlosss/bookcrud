package com.bookstorage.bookdemo.service;

import com.bookstorage.bookdemo.entity.BookEntity;

import java.util.List;

public interface BookService {
  void saveBook(BookEntity book);
  void deleteBook(BookEntity book);
  List<BookEntity> getAllBooks();
}
