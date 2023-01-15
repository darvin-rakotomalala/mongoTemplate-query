package com.poc.service.application;

import com.poc.model.dto.TutorialDTO;

import java.util.List;
import java.util.UUID;

public interface TutorialCUDSA {
    public TutorialDTO createTutorial(TutorialDTO tutorialDTO);
    public List<TutorialDTO> saveAllTutorials(List<TutorialDTO> tutorials);
    public TutorialDTO updateTutorial(TutorialDTO tutorialDTO);
    public void deleteTutorialById(UUID id);
}
