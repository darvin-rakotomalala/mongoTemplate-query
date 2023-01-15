package com.poc.service.business;

import com.poc.model.domain.Tutorial;

import java.util.List;
import java.util.UUID;

public interface TutorialCUDSM {
    public Tutorial createTutorial(Tutorial tutorial);
    public List<Tutorial> saveAllTutorials(List<Tutorial> tutorials);
    public Tutorial updateTutorial(Tutorial tutorial);
    public void deleteTutorialById(UUID id);
}
