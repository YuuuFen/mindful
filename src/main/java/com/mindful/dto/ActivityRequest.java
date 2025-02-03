package com.mindful.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.Set;

public class ActivityRequest {
    private String name;

    @JsonProperty("duration_minutes") // 確保 JSON 解析正確
    private int durationMinutes;

    private LocalDateTime date;

    @JsonProperty("mood_rating") // 確保 JSON 解析正確
    private int moodRating;

    private Set<Long> feelingIds;

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public int getMoodRating() {
        return moodRating;
    }

    public Set<Long> getFeelingIds() {
        return feelingIds;
    }
}
