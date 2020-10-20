package com.bookstorage.bookdemo.controller;

import com.bookstorage.bookdemo.entity.ShapeEntity;
import com.bookstorage.bookdemo.model.ShapeModel;
import com.bookstorage.bookdemo.service.ShapeServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping("/get_maps_query")
  public String getShapesQuery() {
    /*List<ShapeEntity> shapeEntitiesAll = shapeService.getAllShapesQuery();
    System.out.println(shapeEntitiesAll.toString());

    System.out.println("--- >");

    List<ShapeEntity> shapeEntityList = shapeService.findShapeNative();
    System.out.println(shapeEntityList.toString());

    System.out.println("--- >");

    List<String> shapeLabels = shapeService.findShapeLabels();
    System.out.println(shapeLabels.toString());

    System.out.println("--- >");

    ShapeEntity entity = shapeService.findShape();
    System.out.println(entity.toString());

    System.out.println("--- >");*/

    Pageable pageable = PageRequest.of(0, 5);
    List<ShapeEntity> shapeEntities = shapeService.findAllShapesPaginated(pageable);
    for (ShapeEntity shapeEntity : shapeEntities) {
      System.out.println(shapeEntity.toString());
    }

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