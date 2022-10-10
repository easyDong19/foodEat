package dev.be.foodeat.request;

import lombok.Data;

@Data
public class UserRequest {
    private Gender gender;
    private int age;
    private double height;
    private double weight;
}
