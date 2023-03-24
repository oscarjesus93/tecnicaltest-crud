package com.technicaltest.test.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    private String nombre;

    @JsonProperty("date")
    private LocalDate fecha;

    @JsonProperty("startActivity")
    private LocalDate inicioActividad;

    @JsonProperty("color")
    private String color;

    @JsonProperty("price")
    private double precio;

    @JsonProperty("field")
    private String campos;

    @JsonProperty("offer")
    private boolean oferta;

}
