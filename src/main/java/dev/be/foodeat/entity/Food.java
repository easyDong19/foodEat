package dev.be.foodeat.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food {
    @Id @GeneratedValue
    @Column(name = "food_id")
    private Long id;
    private String name;
    private double kcal;
    private double protein;
    private double fat;
    private double carbo;

    @OneToMany(mappedBy = "food")
    private List<Food_diet> food_list = new ArrayList<>();

    public Food(String name){
        this.name = name;
    }

    //==연관관계 메서드==//



}
