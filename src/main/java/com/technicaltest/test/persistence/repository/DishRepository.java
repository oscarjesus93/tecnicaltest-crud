package com.technicaltest.test.persistence.repository;

import com.technicaltest.test.persistence.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    @Query(value = "select * from dish", nativeQuery = true)
    public List<Dish> listDishFilter(LocalDate date);

}
