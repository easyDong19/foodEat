package dev.be.foodeat.repository;

import dev.be.foodeat.entity.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepository extends JpaRepository<Diet,Long> {
}
