package com.bookstorage.bookdemo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shape")
public class ShapeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String color;

  @Column
  private String label;

  @Column
  private String coordinates;

  @Column(name = "geometry_name")
  private String geometryName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(String coordinates) {
    this.coordinates = coordinates;
  }

  public String getGeometryName() {
    return geometryName;
  }

  public void setGeometryName(String geometryName) {
    this.geometryName = geometryName;
  }
}
