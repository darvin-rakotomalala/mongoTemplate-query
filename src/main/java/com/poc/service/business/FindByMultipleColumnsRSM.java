package com.poc.service.business;

import com.poc.model.domain.Tutorial;

import java.util.List;

public interface FindByMultipleColumnsRSM {
    List<Tutorial> getByLevelAndPublished(int level, boolean isPublished);
    List<Tutorial> getByTitleAndPublished(String title, boolean isPublished);
    List<Tutorial> getByTitleOrDescription(String title, String description);
}
