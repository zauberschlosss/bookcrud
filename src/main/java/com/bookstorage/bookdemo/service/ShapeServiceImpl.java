package com.bookstorage.bookdemo.service;

import com.bookstorage.bookdemo.entity.ShapeEntity;
import com.bookstorage.bookdemo.model.ShapeModel;
import com.bookstorage.bookdemo.repository.ShapeRepository;
import com.bookstorage.bookdemo.service.mapper.ShapeMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
public class ShapeServiceImpl implements ShapeService {

  @PersistenceContext
  private EntityManager em;

  private final ShapeRepository shapeRepository;
  private final ShapeMapper shapeMapper;

  public ShapeServiceImpl(ShapeRepository shapeRepository, ShapeMapper shapeMapper) {
    this.shapeRepository = shapeRepository;
    this.shapeMapper = shapeMapper;
  }

  @Override
  public ShapeEntity saveShape(ShapeEntity shape) {
    return shapeRepository.save(shape);
  }

  @Override
  public ShapeEntity saveShape(ShapeModel shape) {
    return saveShape(shapeMapper.convertToEntity(shape));
  }

  @Override
  public void deleteShape(ShapeEntity shape) {
    shapeRepository.delete(shape);
  }

  @Override
  public void deleteShapeById(Long id) {
    shapeRepository.deleteById(id);
  }

  @Override
  public List<ShapeEntity> getAllShapes() {
    return (List<ShapeEntity>) shapeRepository.findAll();
  }

  @Override
  public List<ShapeEntity> getAllShapesQuery() {
    return shapeRepository.getAllShapesQuery();
  }

  @Override
  public List<ShapeEntity> findShapeNative() {
    return shapeRepository.findShapeNative();
  }

  @Override
  public List<String> findShapeLabels() {
    return shapeRepository.findShapeLabels();
  }

  @Override
  public ShapeEntity findShape() {
    return shapeRepository.findShape();
  }

  @Override
  public List<ShapeEntity> findAllShapesPaginated(Pageable pageable) {
    Page<ShapeEntity> entitiesPage = shapeRepository.findAll(pageable);

    return entitiesPage.getContent();
  }
}