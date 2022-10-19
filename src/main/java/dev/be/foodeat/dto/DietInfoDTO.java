package dev.be.foodeat.dto;

import dev.be.foodeat.entity.Diet;
import lombok.Getter;

@Getter
public class DietInfoDTO {
    private String name;
    private double kcal;
    private double protein;
    private double fat;
    private double carbo;

    public DietInfoDTO(Diet diet) {
        this.name = diet.getName();
        this.kcal = diet.getKcal();
        this.protein = diet.getProtein();
        this.fat = diet.getFat();
        this.carbo = diet.getCarbo();
    }
}
