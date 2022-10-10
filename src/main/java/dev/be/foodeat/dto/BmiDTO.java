package dev.be.foodeat.dto;

import lombok.Data;

@Data
public class BmiDTO {
    private double index;
    private double[] ideal_weight;
    private double kcal;
}
