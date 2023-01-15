package com.poc.service.business;

import com.poc.model.domain.Tutorial;
import com.poc.repository.FindByFieldCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class FindByFieldRSMImpl implements FindByFieldRSM {

    private final FindByFieldCustomRepository findByFieldCustomRepository;

    @Override
    public List<Tutorial> getByLevel(int level) {
        try {
            log.info("----- getByLevel : {}", level);
            return findByFieldCustomRepository.findByLevel(level);
        } catch (Exception e) {
            log.error("Error getByLevel : {} : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Tutorial> getByLevelEquals(int level) {
        try {
            log.info("----- getByLevelEquals : {}", level);
            return findByFieldCustomRepository.findByLevelEquals(level);
        } catch (Exception e) {
            log.error("Error getByLevelEquals : {} : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Tutorial> getByPublished(boolean isPublished) {
        try {
            log.info("----- getByPublished : {}", isPublished);
            return findByFieldCustomRepository.findByPublished(isPublished);
        } catch (Exception e) {
            log.error("Error getByPublished : {} : {}", e.getMessage(), e);
            throw e;
        }
    }

}
