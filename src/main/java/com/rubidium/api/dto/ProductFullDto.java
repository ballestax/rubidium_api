package com.rubidium.api.dto;

import java.math.BigDecimal;
import java.util.List;

import com.rubidium.api.model.Presentation;

import lombok.Data;

@Data
public class ProductFullDto {

    private String name;
    private String category;
    private String image;
    private BigDecimal price;
    private boolean variable;
    private List<Presentation> presentations;


}
