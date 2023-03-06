package com.technicaltest.test.service;

import com.technicaltest.test.exceptions.Exceptions;
import com.technicaltest.test.mapper.DishMapper;
import com.technicaltest.test.persistence.dto.DishDto;
import com.technicaltest.test.persistence.entity.Dish;
import com.technicaltest.test.persistence.repository.DishRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    private final DishRepository repository;
    private final DishMapper dishMapper;

    public DishService(DishRepository repository, DishMapper dishMapper){
        this.repository = repository;
        this.dishMapper = dishMapper;
    }

    public Dish findById(Long id){
        Optional<Dish> entity = this.repository.findById(id);

        if(entity.isEmpty()){
            throw new Exceptions("The dish not found", HttpStatus.NOT_FOUND);
        }

        return entity.get();
    }

    public List<Dish> findAll(){
        List<Dish> dishes = this.repository.listDishFilter(LocalDate.now());

        if(dishes.isEmpty()){
            throw new Exceptions("Not found registers", HttpStatus.NOT_FOUND);
        }

        return dishes;
    }

    public Dish createDish(DishDto dishDto){
        Dish dish = this.dishMapper.MapDtoEntity(dishDto);

        return this.repository.save(dish);
    }

    @Transactional
    public Dish updateDish(DishDto dishDto, Long id){

        Dish dish = this.findById(id);

        dish.setCampos(dishDto.getCampos());
        dish.setNombre(dishDto.getNombre());
        dish.setColor(dishDto.getColor());
        dish.setOferta( (dishDto.getOferta() == 1) ? true : false );
        dish.setPrecio(dishDto.getPrecio());

        return this.repository.save(dish);
    }

    public void deleteDish(Long id){
        Optional<Dish> entity = this.repository.findById(id);

        if(entity.isEmpty()){
            throw new Exceptions("The dish not found", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }

}
