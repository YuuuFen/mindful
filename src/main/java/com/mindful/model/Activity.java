package com.mindful.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Integer durationMinutes;

    @Column(nullable = false)
    private Integer moodRating;

    @ManyToMany
    @JoinTable(
            name = "activity_feeling",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "feeling_id")
    )
    private Set<Feeling> feelings = new HashSet<>();

    public Activity() {}

    public Activity(String name, LocalDateTime date, int durationMinutes, int moodRating) {
        this.name = name;
        this.date = date;
        this.durationMinutes = durationMinutes;
        this.moodRating = moodRating;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @JsonProperty("duration_minutes")
    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    @JsonProperty("mood_rating")
    public int getMoodRating() {
        return moodRating;
    }

    public void setMoodRating(int moodRating) {
        this.moodRating = moodRating;
    }

    public Set<Feeling> getFeelings() {
        return feelings;
    }

    public void setFeelings(Set<
            Feeling> feelings) {
        this.feelings = feelings;
    }
}
