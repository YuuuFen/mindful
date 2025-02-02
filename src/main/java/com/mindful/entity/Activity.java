package com.mindful.entity;

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

    private String description;

    @Column(name = "duration_minutes", nullable = false)
    private int durationMinutes;

    @Column(name = "date", nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    @Column(name = "mood_score")
    private Integer moodScore;

    @ManyToMany
    @JoinTable(
            name = "activity_feeling",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "feeling_id")
    )
    private Set<Feeling> feelings = new HashSet<>();

    // Getters and Setters
}
