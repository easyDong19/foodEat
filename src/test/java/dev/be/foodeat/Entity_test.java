package dev.be.foodeat;

import dev.be.foodeat.entity.Diet;
import dev.be.foodeat.entity.Food;
import dev.be.foodeat.entity.Food_diet;
import dev.be.foodeat.repository.DietRepository;
import dev.be.foodeat.repository.FoodRepository;
import dev.be.foodeat.repository.Food_dietRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
@ActiveProfiles("local")
public class Entity_test {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    DietRepository dietRepository;
    @Autowired
    Food_dietRepository food_dietRepository;

    @Test
    @Profile("local")
    public void 엔티티_정상_연결(){
        //food 생성
        Food food1 = new Food("food1");
        Food food2 = new Food("food2");
        Food food3 = new Food("food3");
        foodRepository.save(food1);
        foodRepository.save(food2);
        foodRepository.save(food3);

        //diet 생성
        Diet diet1 = new Diet("diet1");
        Diet diet2 = new Diet("diet2");
        Diet diet3 = new Diet("diet3");
        dietRepository.save(diet1);
        dietRepository.save(diet2);
        dietRepository.save(diet3);

        //둘이 연관관계
        Food_diet fd1 = new Food_diet(food1, diet1);
        Food_diet fd2 = new Food_diet(food2, diet1);
        Food_diet fd3 = new Food_diet(food3, diet1);
        Food_diet fd4 = new Food_diet(food1, diet2);


        food_dietRepository.save(fd1);
        food_dietRepository.save(fd2);
        food_dietRepository.save(fd3);
        food_dietRepository.save(fd4);


        Optional<Food> findFood = foodRepository.findById(1L);
        findFood.get().getFood_list().stream().forEach((a) -> {
            System.out.println(a.getId());
        });

    }
}
