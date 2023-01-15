package com.poc.repository;

import com.poc.model.domain.Tutorial;

import java.util.List;

public interface FindByMultipleColumnsCustomRepository {
    List<Tutorial> findByLevelAndPublished(int level, boolean isPublished);
    List<Tutorial> findByTitleAndPublished(String title, boolean isPublished);
    List<Tutorial> findByTitleOrDescription(String title, String description);
}
