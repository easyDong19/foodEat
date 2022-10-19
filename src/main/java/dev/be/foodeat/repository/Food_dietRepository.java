package dev.be.foodeat.repository;

import dev.be.foodeat.entity.Diet;
import dev.be.foodeat.entity.Food;
import dev.be.foodeat.entity.Food_diet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Food_dietRepository extends JpaRepository<Food_diet,Long> {


}
