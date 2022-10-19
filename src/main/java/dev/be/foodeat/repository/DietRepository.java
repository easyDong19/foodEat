package dev.be.foodeat.repository;

import dev.be.foodeat.entity.Diet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface DietRepository extends JpaRepository<Diet,Long> {
    //name으로 검색하는 메서드
    Page<Diet> findDietByNameContaining(String name, Pageable pageable);

    //추천 식단 레시피(하한 칼로리~ 상항 칼로리)
    List<Diet> findDietByKcalBetween(double Min_kcal, double Max_kcal);


}
