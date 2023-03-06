package com.technicaltest.test.persistence.repository;

import com.technicaltest.test.persistence.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
