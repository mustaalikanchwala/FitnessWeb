package com.fitness.activityServices.service;

import com.fitness.activityServices.dto.ActivityRequest;
import com.fitness.activityServices.dto.ActivityResponse;
import com.fitness.activityServices.exception.InValidUserException;
import com.fitness.activityServices.model.Activity;
import com.fitness.activityServices.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserValidationService userValidationService;
    private final KafkaTemplate<Long,Activity> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    public ActivityResponse saveActivity(ActivityRequest request) {
        boolean isValidUser = userValidationService.validateUser(request.userId());
        if(!isValidUser) throw new InValidUserException("Invalid User "+request.userId());
        Activity activity = ActivityRequest.saveactivity(request);
        Activity savedActivity = activityRepository.save(activity);

        try{
            kafkaTemplate.send(topicName,savedActivity.getUserId(),savedActivity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ActivityResponse.activityResponse(savedActivity);
    }
}
