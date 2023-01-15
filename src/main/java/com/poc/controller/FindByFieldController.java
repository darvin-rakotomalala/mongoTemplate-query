package com.poc.controller;

import com.poc.model.dto.TutorialDTO;
import com.poc.service.application.FindByFieldRSA;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "tutorials/byField")
public class FindByFieldController {

    private final FindByFieldRSA findByFieldRSA;

    @Operation(summary = "WS used to get tutorials by level")
    @GetMapping("/levelIs")
    public List<TutorialDTO> getByLevel(@RequestParam(name = "level", defaultValue = "0", required = true) int level) {
        return findByFieldRSA.getByLevel(level);
    }

    @Operation(summary = "WS used to get tutorials by levelEquals")
    @GetMapping("/levelEquals")
    public List<TutorialDTO> getByLevelEquals(@RequestParam(name = "level", defaultValue = "0", required = true) int level) {
        return findByFieldRSA.getByLevelEquals(level);
    }

    @Operation(summary = "WS used to get tutorials by published")
    @GetMapping("/isPublished")
    public List<TutorialDTO> getByPublished(@RequestParam(name = "published", defaultValue = "true", required = true) boolean isPublished) {
        return findByFieldRSA.getByPublished(isPublished);
    }

}
