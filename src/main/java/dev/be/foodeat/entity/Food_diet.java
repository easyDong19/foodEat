package dev.be.foodeat.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food_diet {
    @Id
    @GeneratedValue
    @Column(name = "food_diet_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diet_id")
    private Diet diet;



    public Food_diet(Food food, Diet diet){
        this.food = food;
        this.diet = diet;

        this.getFood().getFood_list().add(this);
        this.getDiet().getDiet_list().add(this);


    }






}
