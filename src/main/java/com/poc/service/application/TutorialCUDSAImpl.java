package com.poc.service.application;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.dto.TutorialDTO;
import com.poc.mapper.TutorialMapper;
import com.poc.service.business.TutorialCUDSM;
import com.poc.service.business.TutorialRSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TutorialCUDSAImpl implements TutorialCUDSA {

    private final TutorialCUDSM tutorialCUDSM;
    private final TutorialRSM tutorialRSM;
    private final TutorialMapper tutorialMapper;

    @Override
    public TutorialDTO createTutorial(TutorialDTO tutorialDTO) {
        if (tutorialDTO == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_TUTORIAL_OBJECT_EMPTY.getErrorMessage());
        }
        return tutorialMapper.toDTO(tutorialCUDSM.createTutorial(tutorialMapper.toDO(tutorialDTO)));
    }

    @Override
    public List<TutorialDTO> saveAllTutorials(List<TutorialDTO> tutorials) {
        return tutorialMapper.toDTO(tutorialCUDSM.saveAllTutorials(tutorialMapper.toDO(tutorials)));
    }

    @Override
    public TutorialDTO updateTutorial(TutorialDTO tutorialDTO) {
        if (tutorialDTO == null || tutorialDTO.getId() == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_TUTORIAL_OBJECT_EMPTY.getErrorMessage());
        }
        return tutorialMapper.toDTO(tutorialCUDSM.updateTutorial(tutorialMapper.toDO(tutorialDTO)));
    }

    @Override
    public void deleteTutorialById(UUID id) {
        tutorialCUDSM.deleteTutorialById(id);
    }
}
