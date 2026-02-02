package com.fitness.activityServices.controller;

import com.fitness.activityServices.dto.ActivityRequest;
import com.fitness.activityServices.dto.ActivityResponse;
import com.fitness.activityServices.model.Activity;
import com.fitness.activityServices.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/save")
    public ResponseEntity<ActivityResponse> saveActivity(@RequestBody ActivityRequest request){
        return ResponseEntity.ok(activityService.saveActivity(request));
    }

}
