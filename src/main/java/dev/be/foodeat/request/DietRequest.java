package dev.be.foodeat.request;

import lombok.Getter;

@Getter
public class DietRequest {
    private double idealWeight;

    public DietRequest(double idealWeight) {
        this.idealWeight = idealWeight;
    }
}
