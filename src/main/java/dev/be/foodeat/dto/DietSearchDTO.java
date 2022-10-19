package dev.be.foodeat.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class DietSearchDTO {
    private Long id;
    private String name;
    private List<String> recipe;

    protected DietSearchDTO(){

    }

    public DietSearchDTO(String name) {
        this.name = name;
    }

    public DietSearchDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DietSearchDTO(Long id, String name, List<String> recipe) {
        this.id = id;
        this.name = name;
        this.recipe = recipe;
    }
}
