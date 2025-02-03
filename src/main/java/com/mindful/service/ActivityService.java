package com.mindful.service;

import com.mindful.model.Activity;
import com.mindful.model.Feeling;
import com.mindful.repository.ActivityRepository;
import com.mindful.repository.FeelingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final FeelingRepository feelingRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository, FeelingRepository feelingRepository) {
        this.activityRepository = activityRepository;
        this.feelingRepository = feelingRepository;
    }

    @Transactional
    public Activity createActivity(Activity activity, Set<Long> feelingIds) {
        System.out.println("Received feelingIds: " + feelingIds); // Debug

        if (feelingIds == null || feelingIds.isEmpty()) {
            activity.setFeelings(new HashSet<>()); // 如果沒有 feelingIds，就設為空的 Set
        } else {
            Set<Feeling> feelings = new HashSet<>(feelingRepository.findAllById(feelingIds));
            System.out.println("Fetched feelings: " + feelings); // Debug
            activity.setFeelings(feelings);
        }

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
