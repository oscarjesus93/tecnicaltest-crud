package com.technicaltest.test.persistence.entity;

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
    private String nombre;
    private LocalDate fecha;
    private LocalDate inicioActividad;
    private String color;
    private double precio;
    private String campos;
    private boolean oferta;

}
