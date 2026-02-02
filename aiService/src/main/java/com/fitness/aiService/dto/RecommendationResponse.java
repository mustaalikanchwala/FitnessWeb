package com.fitness.aiService.dto;

import com.fitness.aiService.model.Recommendation;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record RecommendationResponse(
        String id,
        String activityId,
        Long userId,
        String recommendation,
        List<String> improvements,
        List<String> suggestions,
        List<String> safety,
        LocalDateTime createdAt
) {
    public static RecommendationResponse recomToresponse(Recommendation recommendation){
        return RecommendationResponse.builder()
                .createdAt(recommendation.getCreatedAt())
                .recommendation(recommendation.getRecommendation())
                .id(recommendation.getId())
                .activityId(recommendation.getActivityId())
                .userId(recommendation.getUserId())
                .improvements(recommendation.getImprovements())
                .safety(recommendation.getSafety())
                .suggestions(recommendation.getSuggestions())
                .build();
    }
}
