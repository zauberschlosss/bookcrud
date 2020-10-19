package com.bookstorage.bookdemo.model;

public class ShapeModel {
  private String color;
  private String label;
  private String coordinates;
  private String geometryName;

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

  @Override
  public String toString() {
    return "ShapeModel{" +
        "color='" + color + '\'' +
        ", label='" + label + '\'' +
        ", coordinates='" + coordinates + '\'' +
        ", geometryName='" + geometryName + '\'' +
        '}';
  }
}
