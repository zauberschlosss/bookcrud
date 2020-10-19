package com.bookstorage.bookdemo.service.mapper;

import java.util.ArrayList;
import java.util.List;

public interface ToEntityMapper<E, D> {
  E convertToEntity(D dto);

  default List<E> convertToEntity(List<D> dtoList) {
    List<E> entitiesList = new ArrayList<>();
    for (D dto : dtoList) {
      entitiesList.add(convertToEntity(dto));
    }

    return entitiesList;
  }
}
