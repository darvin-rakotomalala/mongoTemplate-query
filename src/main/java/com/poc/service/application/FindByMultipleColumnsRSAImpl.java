package com.poc.service.application;

import com.poc.mapper.TutorialMapper;
import com.poc.model.dto.TutorialDTO;
import com.poc.service.business.FindByMultipleColumnsRSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindByMultipleColumnsRSAImpl implements FindByMultipleColumnsRSA {

    private final FindByMultipleColumnsRSM findByMultipleColumnsRSM;
    private final TutorialMapper tutorialMapper;

    @Override
    public List<TutorialDTO> getByLevelAndPublished(int level, boolean isPublished) {
        return tutorialMapper.toDTO(findByMultipleColumnsRSM.getByLevelAndPublished(level, isPublished));
    }

    @Override
    public List<TutorialDTO> getByTitleAndPublished(String title, boolean isPublished) {
        return tutorialMapper.toDTO(findByMultipleColumnsRSM.getByTitleAndPublished(title, isPublished));
    }

    @Override
    public List<TutorialDTO> getByTitleOrDescription(String title, String description) {
        return tutorialMapper.toDTO(findByMultipleColumnsRSM.getByTitleOrDescription(title, description));
    }

}
