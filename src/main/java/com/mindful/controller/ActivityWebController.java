package com.mindful.controller;

import com.mindful.dto.ActivityRequest;
import com.mindful.model.Activity;
import com.mindful.model.Feeling;
import com.mindful.service.ActivityService;
import com.mindful.service.FeelingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
public class ActivityWebController {

    private final ActivityService activityService;
    private final FeelingService feelingService;

    @Autowired
    public ActivityWebController(ActivityService activityService, FeelingService feelingService) {
        this.activityService = activityService;
        this.feelingService = feelingService;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Activity> activities = activityService.getAllActivities();
        List<Feeling> feelings = feelingService.getAllFeelings();

        model.addAttribute("activities", activities);
        model.addAttribute("feelings", feelings);
        model.addAttribute("activityRequest", new ActivityRequest());

        return "index"; // Thymeleaf 會渲染 index.html
    }

    @PostMapping("/add-activity")
    public String addActivity(@ModelAttribute @Valid ActivityRequest request,
                              @RequestParam(required = false) List<Long> feelingIds,
                              BindingResult result) { // 檢查錯誤
        if (result.hasErrors()) {
            System.out.println("Validation Errors: " + result.getAllErrors());
            return "redirect:/error"; // 錯誤時回到錯誤頁面
        }

        System.out.println("Received name: " + request.getName()); // Debug
        System.out.println("Received duration: " + request.getDurationMinutes());
        System.out.println("Received moodRating: " + request.getMoodRating());
        System.out.println("Received feelingIds: " + feelingIds);

        if (feelingIds == null) {
            feelingIds = new ArrayList<>();
        }

        Activity activity = new Activity(
                request.getName(),
                request.getDate(),
                request.getDurationMinutes(),
                request.getMoodRating()
        );

        activityService.createActivity(activity, new HashSet<>(feelingIds));
        return "redirect:/?success";
    }
}
