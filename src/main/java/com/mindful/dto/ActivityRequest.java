package com.mindful.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Set;

public class ActivityRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @JsonProperty("duration_minutes") // 確保 JSON 解析正確
    private int durationMinutes;

    private LocalDateTime date;

    @JsonProperty("mood_rating") // 確保 JSON 解析正確
    private int moodRating;

    private Set<Long> feelingIds;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public int getMoodRating() { return moodRating; }
    public void setMoodRating(int moodRating) { this.moodRating = moodRating; }

    public Set<Long> getFeelingIds() { return feelingIds; }
    public void setFeelingIds(Set<Long> feelingIds) { this.feelingIds = feelingIds; }
}
