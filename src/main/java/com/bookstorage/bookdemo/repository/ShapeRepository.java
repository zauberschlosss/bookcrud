package com.bookstorage.bookdemo.repository;

import com.bookstorage.bookdemo.entity.ShapeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ShapeRepository extends PagingAndSortingRepository<ShapeEntity, Long> {

    @Query("from ShapeEntity s where s.id=5")
    List<ShapeEntity> getAllShapesQuery();

    List<ShapeEntity> findShapeNative();
    List<String> findShapeLabels();
    ShapeEntity findShape();
}