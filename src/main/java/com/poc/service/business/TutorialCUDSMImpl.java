package com.poc.service.business;

import com.poc.model.domain.Tutorial;
import com.poc.repository.TutorialCustomRepository;
import com.poc.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class TutorialCUDSMImpl implements TutorialCUDSM {

    private final TutorialCustomRepository tutorialCustomRepository;

    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        try {
            log.info("----- createTutorial");
            return tutorialCustomRepository.createTutorial(tutorial);
        } catch (Exception e) {
            log.error("Error createTutorial : {} : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Tutorial> saveAllTutorials(List<Tutorial> tutorials) {
        try {
            log.info("----- saveAllTutorials");
            return tutorialCustomRepository.saveAllTutorials(tutorials);
        } catch (Exception e) {
            log.error("Error saveAllTutorials : {} : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Tutorial updateTutorial(Tutorial tutorial) {
        try {
            log.info("----- updateTutorial");
            return tutorialCustomRepository.updateTutorial(tutorial);
        } catch (Exception e) {
            log.error("Error updateTutorial : {} : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteTutorialById(UUID id) {
        try {
            log.info("----- deleteTutorialById : {}", id);
            tutorialCustomRepository.deleteTutorialById(id);
        } catch (Exception e) {
            log.error("Error deleteTutorialById : {} : {}", e.getMessage(), e);
            throw e;
        }
    }

}
