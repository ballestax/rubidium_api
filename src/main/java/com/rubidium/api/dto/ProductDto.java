package com.rubidium.api.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDto {

    private long id;
    private String name;
    private String category;
    private BigDecimal price;
    private String image;

}
