package com.bookstorage.bookdemo.service;

import com.bookstorage.bookdemo.entity.ShapeEntity;
import com.bookstorage.bookdemo.model.ShapeModel;
import com.bookstorage.bookdemo.repository.ShapeRepository;
import com.bookstorage.bookdemo.service.mapper.ShapeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeServiceImpl implements ShapeService {

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
}