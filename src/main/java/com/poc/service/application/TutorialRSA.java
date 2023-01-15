package com.poc.service.application;

import com.poc.model.dto.TutorialDTO;
import com.poc.utils.HelpPage;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TutorialRSA {
    public TutorialDTO getTutorialById(UUID id);
    public HelpPage<TutorialDTO> getAllTutorials(Pageable pageable);
    public HelpPage<TutorialDTO> getAllTutorialsByTitle(String title, Pageable pageable);
}
