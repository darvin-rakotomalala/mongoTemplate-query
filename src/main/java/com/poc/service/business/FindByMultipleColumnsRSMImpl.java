package com.poc.service.business;

import com.poc.model.domain.Tutorial;
import com.poc.repository.FindByMultipleColumnsCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class FindByMultipleColumnsRSMImpl implements FindByMultipleColumnsRSM {

    private final FindByMultipleColumnsCustomRepository findByMultipleColumnsCustomRepository;

    @Override
    public List<Tutorial> getByLevelAndPublished(int level, boolean isPublished) {
        try {
            log.info("----- getByLevelAndPublished : {} {}", level, isPublished);
            return findByMultipleColumnsCustomRepository.findByLevelAndPublished(level, isPublished);
        } catch (Exception e) {
            log.error("Error getByLevelAndPublished : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Tutorial> getByTitleAndPublished(String title, boolean isPublished) {
        try {
            log.info("----- getByTitleAndPublished : {} {}", title, isPublished);
            return findByMultipleColumnsCustomRepository.findByTitleAndPublished(title, isPublished);
        } catch (Exception e) {
            log.error("Error getByTitleAndPublished : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Tutorial> getByTitleOrDescription(String title, String description) {
        try {
            log.info("----- getByTitleOrDescription : {} {}", title, description);
            return findByMultipleColumnsCustomRepository.findByTitleOrDescription(title, description);
        } catch (Exception e) {
            log.error("Error getByTitleOrDescription : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
