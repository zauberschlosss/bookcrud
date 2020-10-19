package com.bookstorage.bookdemo.service.mapper;

import com.bookstorage.bookdemo.entity.ShapeEntity;
import com.bookstorage.bookdemo.model.ShapeModel;
import org.springframework.stereotype.Component;

@Component
public class ShapeMapper implements EntityMapper<ShapeEntity, ShapeModel> {
  @Override
  public ShapeModel convertToDto(ShapeEntity entity) {
    return null;
  }

  @Override
  public ShapeEntity convertToEntity(ShapeModel dto) {
    ShapeEntity shapeEntity = new ShapeEntity();
    shapeEntity.setColor(dto.getColor());
    shapeEntity.setLabel(dto.getLabel());
    shapeEntity.setCoordinates("[" + dto.getCoordinates() + "]");
    shapeEntity.setGeometryName(dto.getGeometryName());

    return shapeEntity;
  }
}