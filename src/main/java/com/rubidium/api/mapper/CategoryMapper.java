package com.rubidium.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rubidium.api.dto.CategoryDto;
import com.rubidium.api.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto entityToDto(Category entity);

    Category dtoToEntity(CategoryDto dto);
}
