package com.poc.repository;

import com.poc.model.domain.Tutorial;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindByFieldCustomRepositoryImpl implements FindByFieldCustomRepository {

    public static final String TUTORIAL_COLLECTION = "tutorials";
    private final MongoTemplate mongoTemplate;

    @Override
    public List<Tutorial> findByLevel(int level) {
        Query query = new Query();
        query.addCriteria(Criteria.where("level").is(level));
        return mongoTemplate.find(query, Tutorial.class);
    }

    @Override
    public List<Tutorial> findByLevelEquals(int level) {
        Query query = new Query();
        query.addCriteria(Criteria.where("level").is(level));
        return mongoTemplate.find(query, Tutorial.class);
    }

    @Override
    public List<Tutorial> findByPublished(boolean isPublished) {
        Query query = new Query();
        query.addCriteria(Criteria.where("published").is(isPublished));
        return mongoTemplate.find(query, Tutorial.class);
    }

}
