package com.technicaltest.test.persistence.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DishDto {

    private String nombre;
    private String color;
    private double precio;
    private String campos;
    private Integer oferta;

}
