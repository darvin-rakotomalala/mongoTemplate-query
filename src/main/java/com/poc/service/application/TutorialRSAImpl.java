package com.poc.service.application;

import com.poc.model.dto.TutorialDTO;
import com.poc.mapper.TutorialMapper;
import com.poc.service.business.TutorialRSM;
import com.poc.utils.HelpPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TutorialRSAImpl implements TutorialRSA {

    private final TutorialRSM tutorialRSM;
    private final TutorialMapper tutorialMapper;

    @Override
    public TutorialDTO getTutorialById(UUID id) {
        return tutorialMapper.toDTO(tutorialRSM.getTutorialById(id));
    }

    @Override
    public HelpPage<TutorialDTO> getAllTutorials(Pageable pageable) {
        return tutorialMapper.toDTO(tutorialRSM.getAllTutorials(pageable), pageable);
    }

    @Override
    public HelpPage<TutorialDTO> getAllTutorialsByTitle(String title, Pageable pageable) {
        return tutorialMapper.toDTO(tutorialRSM.getAllTutorialsByTitle(title, pageable), pageable);
    }

}
