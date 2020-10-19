package com.bookstorage.bookdemo.controller;

import com.bookstorage.bookdemo.model.ShapeModel;
import com.bookstorage.bookdemo.service.ShapeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/map")
public class MapController {

  private final ShapeServiceImpl shapeService;

  public MapController(ShapeServiceImpl shapeService) {
    this.shapeService = shapeService;
  }

  @GetMapping
  public String drawMap() {
    return "maps";
  }

  @PostMapping("/save_shapes")
  public String saveObjects(@RequestBody ShapeModel shapeModel) {
    System.out.println(shapeModel.toString());
    System.out.println("--- >");

    shapeService.saveShape(shapeModel);

    return "maps";
  }

  @GetMapping("/get_shapes")
  public ResponseEntity<?> getShapes() {
    return new ResponseEntity<>(
        shapeService.getAllShapes(),
        HttpStatus.OK
    );
  }
}