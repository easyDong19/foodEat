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
public class Diet {
    @Id @GeneratedValue
    @Column(name = "diet_id")
    private Long id;
    private String name;
    private double kcal;
    private double protein;
    private double fat;
    private double carbo;

    @OneToMany(mappedBy = "diet")
    private List<Food_diet> diet_list = new ArrayList<>();

    public Diet(String name){
        this.name = name;
    }

}
