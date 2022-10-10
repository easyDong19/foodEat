package dev.be.foodeat.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseUserDTO<T> {
    private String error;
    private T data;
}
