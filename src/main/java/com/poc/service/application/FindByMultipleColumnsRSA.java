package com.poc.service.application;

import com.poc.model.dto.TutorialDTO;

import java.util.List;

public interface FindByMultipleColumnsRSA {
    List<TutorialDTO> getByLevelAndPublished(int level, boolean isPublished);
    List<TutorialDTO> getByTitleAndPublished(String title, boolean isPublished);
    List<TutorialDTO> getByTitleOrDescription(String title, String description);
}
