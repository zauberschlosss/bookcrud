package com.bookstorage.bookdemo.service;

import com.bookstorage.bookdemo.entity.BookEntity;
import com.bookstorage.bookdemo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public void saveBook(BookEntity book) {
    bookRepository.save(book);
  }

  @Override
  public void deleteBook(BookEntity book) {
    bookRepository.delete(book);
  }

  @Override
  public List<BookEntity> getAllBooks() {
    return (List<BookEntity>) bookRepository.findAll();
  }
}
