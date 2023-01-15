package com.poc.service.business;

import com.poc.model.domain.Tutorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TutorialRSM {
    public Tutorial getTutorialById(UUID id);
    public Page<Tutorial> getAllTutorials(Pageable pageable);
    public Page<Tutorial> getAllTutorialsByTitle(String title, Pageable pageable);
}
