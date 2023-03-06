package com.technicaltest.test.mapper;

import com.technicaltest.test.persistence.dto.DishDto;
import com.technicaltest.test.persistence.entity.Dish;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DishMapper implements IMapper<DishDto, Dish> {


    @Override
    public Dish MapDtoEntity(DishDto in) {
        Dish dish = new Dish();

        dish.setNombre(in.getNombre());
        dish.setFecha(LocalDate.now());
        dish.setInicioActividad(LocalDate.now());
        dish.setColor(in.getColor());
        dish.setPrecio(in.getPrecio());
        dish.setCampos(in.getCampos());
        dish.setOferta( (in.getOferta() == 1) ? true : false );

        return dish;

    }
}
