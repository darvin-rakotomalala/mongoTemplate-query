package com.poc.repository;

import com.poc.model.domain.Tutorial;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindByMultipleColumnsCustomRepositoryImpl implements FindByMultipleColumnsCustomRepository {

    public static final String TUTORIAL_COLLECTION = "tutorials";
    private final MongoTemplate mongoTemplate;

    @Override
    public List<Tutorial> findByLevelAndPublished(int level, boolean isPublished) {
        Query query = new Query();
        query.addCriteria(Criteria.where("level").is(level).and("published").is(isPublished));
        return mongoTemplate.find(query, Tutorial.class);
    }

    @Override
    public List<Tutorial> findByTitleAndPublished(String title, boolean isPublished) {
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("title").is(title), Criteria.where("published").is(isPublished));
        Query query = new Query();
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Tutorial.class);
    }

    @Override
    public List<Tutorial> findByTitleOrDescription(String title, String description) {
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("title").is(title), Criteria.where("description").is(description));
        Query query = new Query();
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Tutorial.class);
    }

}
