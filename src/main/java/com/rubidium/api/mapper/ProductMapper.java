package com.rubidium.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.rubidium.api.dto.ProductDto;
import com.rubidium.api.dto.ProductFullDto;
import com.rubidium.api.model.Product;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "category.name", target = "category")
    ProductDto entityToDto(Product entity);
    List<ProductDto> entityListToToDtoList(List<Product> entityList);


    @Mapping(target = "category", ignore = true)
    Product dtoToEntity(ProductDto dto);

    List<Product> dtoListToEntityList(List<ProductDto> dtoList);

    @Mapping(source = "category.name", target = "category")
    ProductFullDto productToProductFullDto(Product product);

    @Mapping(target = "category", ignore = true)
    Product productFullDtoToProduct(ProductFullDto productFullDto);


}
