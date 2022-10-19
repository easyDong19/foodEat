package dev.be.foodeat.repository;

import dev.be.foodeat.entity.Diet;
import dev.be.foodeat.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food,Long> {


}
