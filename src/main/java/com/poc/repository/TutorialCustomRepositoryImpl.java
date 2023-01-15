package com.poc.repository;

import com.mongodb.client.result.UpdateResult;
import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.Tutorial;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TutorialCustomRepositoryImpl implements TutorialCustomRepository {

    public static final String TUTORIAL_COLLECTION = "tutorials";
    private final MongoTemplate mongoTemplate;

    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        tutorial.setId(UUID.randomUUID());
        tutorial.setCreatedAt(Instant.now());
        tutorial.setUpdatedAt(Instant.now());
        return mongoTemplate.save(tutorial);
    }

    @Override
    public List<Tutorial> saveAllTutorials(List<Tutorial> tutorials) {
        List<Tutorial> newTutorials = new ArrayList<>();
        tutorials.forEach(tutorial -> {
            tutorial.setId(UUID.randomUUID());
            tutorial.setCreatedAt(Instant.now());
            tutorial.setUpdatedAt(Instant.now());
            newTutorials.add(mongoTemplate.save(tutorial));
        });
        return newTutorials;
    }

    @Override
    public Tutorial updateTutorial(Tutorial tutorial) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(tutorial.getId()));

        Tutorial tutorialFound = mongoTemplate.findOne(query, Tutorial.class);
        Update update = new Update();

        if (tutorialFound == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_TUTORIAL_NOT_FOUND.getErrorMessage());
        } else {
            update.set("title", tutorial.getTitle());
            update.set("description", tutorial.getDescription());
            update.set("level", tutorial.getLevel());
            update.set("published", tutorial.isPublished());
            update.set("updatedAt", Instant.now());
        }

        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Tutorial.class);
        if (updateResult.getMatchedCount() == 0 && updateResult.getModifiedCount() == 0) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_TUTORIAL_NO_UPDATE.getErrorMessage());
        }
        return tutorialFound;
    }

    @Override
    public void deleteTutorialById(UUID id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Tutorial tutorialFound = mongoTemplate.findOne(query, Tutorial.class);
        if (tutorialFound == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_TUTORIAL_NOT_FOUND.getErrorMessage());
        }
        mongoTemplate.remove(tutorialFound);
    }

    @Override
    public Tutorial findTutorialById(UUID id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Tutorial tutorialFound = mongoTemplate.findOne(query, Tutorial.class);
        if (tutorialFound != null) {
            return tutorialFound;
        }
        throw new FunctionalException(ErrorsEnum.ERR_MCS_TUTORIAL_NOT_FOUND.getErrorMessage());
    }

    @Override
    public Page<Tutorial> findAllTutorials(Pageable pageable) {
        Query query = new Query();
        query.with(pageable);

        return PageableExecutionUtils.getPage(
                mongoTemplate.find(query, Tutorial.class),
                pageable,
                () -> mongoTemplate.count(query.skip(0).limit(0), Tutorial.class)
        );
    }

    @Override
    public Page<Tutorial> findAllTutorialsByTitle(String title, Pageable pageable) {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(title));
        query.with(pageable);

        return PageableExecutionUtils.getPage(
                mongoTemplate.find(query, Tutorial.class),
                pageable,
                () -> mongoTemplate.count(query.skip(0).limit(0), Tutorial.class)
        );
    }

}
