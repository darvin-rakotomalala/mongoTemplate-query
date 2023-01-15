package com.poc.service.application;

import com.poc.model.dto.TutorialDTO;

import java.util.List;

public interface FindByFieldRSA {
    List<TutorialDTO> getByLevel(int level);
    List<TutorialDTO> getByLevelEquals(int level);
    List<TutorialDTO> getByPublished(boolean isPublished);
}
