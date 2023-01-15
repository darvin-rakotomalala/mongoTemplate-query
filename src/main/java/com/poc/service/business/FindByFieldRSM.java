package com.poc.service.business;

import com.poc.model.domain.Tutorial;

import java.util.List;

public interface FindByFieldRSM {
    List<Tutorial> getByLevel(int level);
    List<Tutorial> getByLevelEquals(int level);
    List<Tutorial> getByPublished(boolean isPublished);
}
