package com.poc.controller;

import com.poc.constraint.validation.TutorialValidator;
import com.poc.model.dto.TutorialDTO;
import com.poc.service.application.TutorialCUDSA;
import com.poc.service.application.TutorialRSA;
import com.poc.utils.HelpPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "tutorials")
public class TutorialController {

    private final TutorialCUDSA tutorialCUDSA;
    private final TutorialRSA tutorialRSA;
    private final TutorialValidator tutorialValidator;

    @InitBinder("tutorialDTO")
    protected void initTutorialDTOBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(tutorialValidator);
    }

    @Operation(summary = "WS used to create Tutorial")
    @PostMapping
    public TutorialDTO createTutorial(@RequestBody @Validated TutorialDTO tutorialDTO) {
        return tutorialCUDSA.createTutorial(tutorialDTO);
    }

    @Operation(summary = "WS used to save list Tutorials")
    @PostMapping("/saveAll")
    public List<TutorialDTO> saveAllTutorials(@RequestBody List<TutorialDTO> tutorials) {
        return tutorialCUDSA.saveAllTutorials(tutorials);
    }

    @Operation(summary = "WS used to update Tutorial")
    @PutMapping
    public TutorialDTO updateTutorial(@RequestBody @Validated TutorialDTO tutorialDTO) {
        return tutorialCUDSA.updateTutorial(tutorialDTO);
    }

    @Operation(summary = "WS used to get all tutorials")
    @GetMapping
    public HelpPage<TutorialDTO> getAllTutorials(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return tutorialRSA.getAllTutorials(pageable);
    }

    @Operation(summary = "WS used to get all tutorials by title")
    @GetMapping("byTitle")
    public HelpPage<TutorialDTO> getAllTutorialsByTitle(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return tutorialRSA.getAllTutorialsByTitle(title, pageable);
    }

    @Operation(summary = "WS used to get Tutorial by id")
    @GetMapping("/{id}")
    public TutorialDTO getTutorialById(@PathVariable("id") UUID id) {
        return tutorialRSA.getTutorialById(id);
    }

    @Operation(summary = "WS used to delete Tutorial by id")
    @DeleteMapping("/{id}")
    public String deleteTutorialById(@PathVariable("id") UUID id) {
        tutorialCUDSA.deleteTutorialById(id);
        return "Tutorial with id " + id + " deleted successfully !";
    }

}
