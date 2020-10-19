package com.bookstorage.bookdemo.repository;

import com.bookstorage.bookdemo.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {

}
