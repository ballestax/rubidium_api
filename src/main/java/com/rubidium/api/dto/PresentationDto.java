package com.rubidium.api.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PresentationDto {

    private String name;
    private BigDecimal price;
    private boolean _default;
    private boolean _enabled;
    private Long product_id;
}
