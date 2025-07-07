package com.rubidium.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rubidium.api.dto.PresentationDto;
import com.rubidium.api.model.Presentation;

@Mapper(componentModel = "spring")
public interface PresentationMapper {

    PresentationMapper INSTANCE = Mappers.getMapper(PresentationMapper.class);

    PresentationDto presentationToPresentationDto(Presentation presentation);

    Presentation presentationDtoToPresentation(PresentationDto presentationDto);

    List<Presentation> presentationDtoListToPresentationList(List<PresentationDto> presentationDtoList);

    List<PresentationDto> presentationListToPresentationDtoList(List<Presentation> presentationList);
}
