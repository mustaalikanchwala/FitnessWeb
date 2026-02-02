package com.fitness.aiService.repository;

import com.fitness.aiService.dto.RecommendationResponse;
import com.fitness.aiService.model.Recommendation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommendationRepository extends MongoRepository<Recommendation,String> {

    List<Recommendation> findByUserId(Long userId);

    Optional<Recommendation> findByActivityId(String activityId);
}
