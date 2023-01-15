package com.poc.repository;

import com.poc.model.domain.Tutorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface TutorialCustomRepository {
    public Tutorial createTutorial(Tutorial tutorial);
    public List<Tutorial> saveAllTutorials(List<Tutorial> tutorials);
    public Tutorial updateTutorial(Tutorial tutorial);
    public void deleteTutorialById(UUID id);
    public Tutorial findTutorialById(UUID id);
    public Page<Tutorial> findAllTutorials(Pageable pageable);
    public Page<Tutorial> findAllTutorialsByTitle(String title, Pageable pageable);
}
