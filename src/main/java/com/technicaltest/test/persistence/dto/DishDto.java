package com.technicaltest.test.persistence.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DishDto {

    @JsonProperty("name")
    private String nombre;

    @JsonProperty("color")
    private String color;

    @JsonProperty("price")
    private double precio;

    @JsonProperty("field")
    private String campos;

    @JsonProperty("offer")
    private Integer oferta;

}
