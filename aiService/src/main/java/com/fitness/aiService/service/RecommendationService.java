package com.fitness.aiService.service;

import com.fitness.aiService.dto.RecommendationResponse;
import com.fitness.aiService.exception.RecommendationNotFoundException;
import com.fitness.aiService.model.Recommendation;
import com.fitness.aiService.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;

    public List<RecommendationResponse> getRecomendationByUserId(Long userId) {
        return recommendationRepository
                .findByUserId(userId)
                .stream()
                .map(RecommendationResponse::recomToresponse)
                .collect(Collectors.toList());
    }

    public RecommendationResponse getRecommendationByActivityId(String activityId) {
        return RecommendationResponse
                .recomToresponse(recommendationRepository
                        .findByActivityId(activityId)
                        .orElseThrow(() -> new RecommendationNotFoundException("Recommendation Not found " +activityId)));
    }


}
