package com.mindful.service;

import com.mindful.model.Activity;
import com.mindful.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity getActivityById(UUID id) {
        Optional<Activity> activity = activityRepository.findById(id);
        return activity.orElse(null);
    }

    public Activity updateActivity(UUID id, Activity activity) {
        if (activityRepository.existsById(id)) {
            activity.setId(id);
            return activityRepository.save(activity);
        }
        return null;
    }

    public boolean deleteActivity(UUID id) {
        if (activityRepository.existsById(id)) {
            activityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
