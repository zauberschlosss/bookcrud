package com.bookstorage.bookdemo.service.mapper;

import java.util.ArrayList;
import java.util.List;

public interface ToDtoMapper<E, D> {
  D convertToDto(E entity);

  default List<D> convertToDto(List<E> entities) {
    List<D> dtoList = new ArrayList<>();
    for (E entity : entities) {
      dtoList.add(convertToDto(entity));
    }

    return dtoList;
  }
}
