package com.rubidium.api.service;

import java.util.List;

import com.rubidium.api.dto.PresentationDto;
import com.rubidium.api.model.Presentation;

public interface PresentationService {

    Presentation savePresentation(Presentation presentation);

    List<PresentationDto> getAllPresentations();

    List<Presentation> getAllPresentationsByProductId(Long productId);

    PresentationDto getPresentationById(long id);

    Presentation updatePresentation(Presentation presentation, long id);

    void delete(long id);

}
