package com.poc.service.business;

import com.poc.model.domain.Tutorial;
import com.poc.repository.TutorialCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class TutorialRSMImpl implements TutorialRSM {

    private final TutorialCustomRepository tutorialCustomRepository;

    @Override
    public Tutorial getTutorialById(UUID id) {
        try {
            log.info("----- getTutorialById : {}", id);
            return tutorialCustomRepository.findTutorialById(id);
        } catch (Exception e) {
            log.error("Error getTutorialById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Page<Tutorial> getAllTutorials(Pageable pageable) {
        try {
            log.info("----- getAllTutorials");
            return tutorialCustomRepository.findAllTutorials(pageable);
        } catch (Exception e) {
            log.error("Error getAllTutorials : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Page<Tutorial> getAllTutorialsByTitle(String title, Pageable pageable) {
        try {
            log.info("----- getAllTutorialsByTitle : {}", title);
            return tutorialCustomRepository.findAllTutorialsByTitle(title, pageable);
        } catch (Exception e) {
            log.error("Error getAllTutorialsByTitle : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
