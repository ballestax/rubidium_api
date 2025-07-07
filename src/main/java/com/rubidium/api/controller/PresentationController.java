package com.rubidium.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubidium.api.dto.PresentationDto;
import com.rubidium.api.model.Presentation;
import com.rubidium.api.service.PresentationService;


@RestController
@RequestMapping("/api/presentations")
public class PresentationController {

    private PresentationService presentationService;

    public PresentationController(PresentationService categoryService) {
        this.presentationService = categoryService;
    }

    @PostMapping()
    public ResponseEntity<Presentation> savePresentation(@RequestBody Presentation presentation) {
        return new ResponseEntity<>(presentationService.savePresentation(presentation), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PresentationDto> getAllPresentations() {
        return presentationService.getAllPresentations();
    }

    @GetMapping("{id}")
    public ResponseEntity<PresentationDto> getPresentationById(@PathVariable("id") long presentationId) {
        return new ResponseEntity<>(presentationService.getPresentationById(presentationId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Presentation> updatePresentation(@PathVariable("id") long id, @RequestBody Presentation presentation) {
        return new ResponseEntity<>(presentationService.updatePresentation(presentation, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePresentation(@PathVariable("id") long id) {
        presentationService.delete(id);
        return new ResponseEntity<>("Presentation deleted successfully!", HttpStatus.OK);
    }


}
