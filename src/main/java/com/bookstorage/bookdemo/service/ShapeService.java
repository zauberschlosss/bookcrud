package com.bookstorage.bookdemo.service;

import com.bookstorage.bookdemo.entity.ShapeEntity;
import com.bookstorage.bookdemo.model.ShapeModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShapeService {
  ShapeEntity saveShape(ShapeEntity user);
  ShapeEntity saveShape(ShapeModel user);
  void deleteShape(ShapeEntity shape);
  void deleteShapeById(Long id);
  List<ShapeEntity> getAllShapes();

  List<ShapeEntity> getAllShapesQuery();
  List<ShapeEntity> findShapeNative();
  List<String> findShapeLabels();
  ShapeEntity findShape();
  List<ShapeEntity> findAllShapesPaginated(Pageable pageable);
}