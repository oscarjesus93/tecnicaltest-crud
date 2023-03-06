package com.technicaltest.test.controller;

import com.technicaltest.test.exceptions.Exceptions;
import com.technicaltest.test.persistence.dto.DishDto;
import com.technicaltest.test.persistence.entity.Dish;
import com.technicaltest.test.service.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/dish")
public class DishController {

    private final DishService service;

    public DishController(DishService service) {
        this.service = service;
    }

    @GetMapping
    public List<Dish> findDish(){
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Dish listFindDish(@PathVariable Long id){
        return this.service.findById(id);
    }

    @PostMapping
    public Dish create(@RequestBody DishDto request){

        if(request.getPrecio() > 25){
            throw new Exceptions("the price cannot exceed 25 usd", HttpStatus.BAD_REQUEST);
        }

        return this.service.createDish(request);
    }

    @PutMapping("/{id}")
    public Dish putDish(@RequestBody DishDto dishDto, @PathVariable Long id){

        return this.service.updateDish(dishDto, id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id){

        this.service.deleteDish(id);
        return ResponseEntity.noContent().build();
    }

}
