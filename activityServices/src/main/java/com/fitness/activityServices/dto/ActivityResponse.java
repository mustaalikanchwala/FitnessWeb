package com.fitness.activityServices.dto;

import com.fitness.activityServices.model.Activity;
import com.fitness.activityServices.model.ActivityType;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
public record ActivityResponse(
        String id,
        Long userId,
        ActivityType type,
        Integer duration,
        Integer caloriesBurned,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Map<String,Object> additionalMetrics,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ActivityResponse activityResponse(Activity activity){
        return ActivityResponse.builder()
                .additionalMetrics(activity.getAdditionalMetrics())
                .id(activity.getId())
                .userId(activity.getUserId())
                .caloriesBurned(activity.getCaloriesBurned())
                .type(activity.getType())
                .duration(activity.getDuration())
                .caloriesBurned(activity.getCaloriesBurned())
                .createdAt(activity.getCreatedAt())
                .updatedAt(activity.getUpdatedAt())
                .startTime(activity.getStartTime())
                .endTime(activity.getEndTime())
                .build();
    }
}
