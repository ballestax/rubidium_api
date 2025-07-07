package com.rubidium.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubidium.api.dto.PresentationDto;
import com.rubidium.api.exception.ResourceNotFoundException;
import com.rubidium.api.mapper.PresentationMapper;
import com.rubidium.api.model.Presentation;
import com.rubidium.api.repository.PresentationRepository;
import com.rubidium.api.service.PresentationService;

@Service
public class PresentationServiceImpl implements PresentationService {

    @Autowired
    private PresentationRepository presentationRepository;

    @Autowired
    private PresentationMapper mapper;

    @Override
    public Presentation savePresentation(Presentation presentation) {
        return presentationRepository.save(presentation);
    }

    @Override
    public List<PresentationDto> getAllPresentations() {
        return presentationRepository.findAll()
                .stream()
                .map(presentation -> mapper.presentationToPresentationDto(presentation))
                .collect(Collectors.toList());
    }

    @Override
    public List<Presentation> getAllPresentationsByProductId(Long productId) {
        return presentationRepository.findPresentationsByProductId(productId);
    }

    @Override
    public PresentationDto getPresentationById(long id) {
        return presentationRepository.findById(id).map(presentation -> mapper.presentationToPresentationDto(presentation)).orElseThrow(()->
                new ResourceNotFoundException("Presentation", "id", id));
    }

    @Override
    public Presentation updatePresentation(Presentation presentation, long id) {
        Presentation existingPresentation = presentationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Presentation", "id", id)
        );
        existingPresentation.setName(presentation.getName());
        existingPresentation.setPrice(presentation.getPrice());
        existingPresentation.set_default(presentation.is_default());
        existingPresentation.set_enabled(presentation.is_enabled());
        existingPresentation.setSerie(presentation.getSerie());

        presentationRepository.save(existingPresentation);
        return existingPresentation;

    }

    @Override
    public void delete(long id) {
        presentationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Presentation", "Id", id));
        presentationRepository.deleteById(id);
    }
}
