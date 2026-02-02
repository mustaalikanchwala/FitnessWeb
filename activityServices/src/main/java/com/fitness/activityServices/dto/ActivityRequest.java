package com.fitness.activityServices.dto;

import com.fitness.activityServices.model.Activity;
import com.fitness.activityServices.model.ActivityType;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Map;
@Builder
public record ActivityRequest(
        Long userId,
        ActivityType type,
        Integer duration,
        Integer caloriesBurned,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Map<String,Object> additionalMetrics
) {
    public static Activity saveactivity(ActivityRequest request){
        return Activity.builder()
                .additionalMetrics(request.additionalMetrics())
                .userId(request.userId())
                .caloriesBurned(request.caloriesBurned())
                .type(request.type())
                .duration(request.duration())
                .caloriesBurned(request.caloriesBurned())
                .startTime(request.startTime())
                .endTime(request.endTime())
                .build();
    }
}
