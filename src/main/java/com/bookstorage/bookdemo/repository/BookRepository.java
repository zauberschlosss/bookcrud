package com.bookstorage.bookdemo.repository;

import com.bookstorage.bookdemo.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
