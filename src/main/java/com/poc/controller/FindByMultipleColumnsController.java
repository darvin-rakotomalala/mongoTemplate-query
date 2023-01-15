package com.poc.controller;

import com.poc.model.dto.TutorialDTO;
import com.poc.service.application.FindByMultipleColumnsRSA;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "tutorials/multipleColumns")
public class FindByMultipleColumnsController {

    private final FindByMultipleColumnsRSA findByMultipleColumnsRSA;

    @Operation(summary = "WS used to get tutorials by level and published")
    @GetMapping("/byLevelAndPublished")
    public List<TutorialDTO> getByLevelAndPublished(
            @RequestParam(name = "level", defaultValue = "0", required = true) int level,
            @RequestParam(name = "published", defaultValue = "true", required = true) boolean isPublished) {
        return findByMultipleColumnsRSA.getByLevelAndPublished(level, isPublished);
    }

    @Operation(summary = "WS used to get tutorials by title and published")
    @GetMapping("/byTitleAndPublished")
    public List<TutorialDTO> getByTitleAndPublished(
            @RequestParam(name = "title", required = true) String title,
            @RequestParam(name = "published", defaultValue = "true", required = true) boolean isPublished) {
        return findByMultipleColumnsRSA.getByTitleAndPublished(title, isPublished);
    }

    @Operation(summary = "WS used to get tutorials by title or description")
    @GetMapping("/byTitleOrDescription")
    public List<TutorialDTO> getByTitleOrDescription(
            @RequestParam(name = "title", required = true) String title,
            @RequestParam(name = "description", required = true) String description) {
        return findByMultipleColumnsRSA.getByTitleOrDescription(title, description);
    }

}
