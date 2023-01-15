package com.poc.service.application;

import com.poc.mapper.TutorialMapper;
import com.poc.model.dto.TutorialDTO;
import com.poc.service.business.FindByFieldRSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindByFieldRSAImpl implements FindByFieldRSA {

    private final FindByFieldRSM findByFieldRSM;
    private final TutorialMapper tutorialMapper;

    @Override
    public List<TutorialDTO> getByLevel(int level) {
        return tutorialMapper.toDTO(findByFieldRSM.getByLevel(level));
    }

    @Override
    public List<TutorialDTO> getByLevelEquals(int level) {
        return tutorialMapper.toDTO(findByFieldRSM.getByLevelEquals(level));
    }

    @Override
    public List<TutorialDTO> getByPublished(boolean isPublished) {
        return tutorialMapper.toDTO(findByFieldRSM.getByPublished(isPublished));
    }

}
