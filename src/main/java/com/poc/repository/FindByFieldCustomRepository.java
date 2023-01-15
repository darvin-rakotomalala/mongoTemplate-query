package com.poc.repository;

import com.poc.model.domain.Tutorial;

import java.util.List;

public interface FindByFieldCustomRepository {
    List<Tutorial> findByLevel(int level);
    List<Tutorial> findByLevelEquals(int level);
    List<Tutorial> findByPublished(boolean isPublished);
}
