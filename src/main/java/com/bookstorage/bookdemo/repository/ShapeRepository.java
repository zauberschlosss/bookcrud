package com.bookstorage.bookdemo.repository;

import com.bookstorage.bookdemo.entity.ShapeEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShapeRepository extends CrudRepository<ShapeEntity, Long> {
}
