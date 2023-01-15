package com.poc.repository;

import com.poc.model.domain.Tutorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.UUID;

public interface TutorialRepository extends MongoRepository<Tutorial, UUID> {
    @Query("{ 'title' : { $regex: ?0 } }")
    Page<Tutorial> findByTitleIgnoreCase(String title, Pageable pageable);
}
