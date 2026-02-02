package com.fitness.aiService.controller;

import com.fitness.aiService.dto.RecommendationResponse;
import com.fitness.aiService.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecommendationResponse>> getUserRecommendation(@PathVariable Long userId){
        return ResponseEntity.ok(recommendationService.getRecomendationByUserId(userId));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<RecommendationResponse> getRecomendationByActivityId(@PathVariable String activityId){
        return ResponseEntity.ok(recommendationService.getRecommendationByActivityId(activityId));
    }
}
