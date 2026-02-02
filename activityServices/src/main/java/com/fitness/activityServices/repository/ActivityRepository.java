package com.fitness.activityServices.repository;

import com.fitness.activityServices.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends MongoRepository<Activity,Long> {
}
