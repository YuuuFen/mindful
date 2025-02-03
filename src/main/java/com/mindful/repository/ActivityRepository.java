package com.mindful.repository;

import com.mindful.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, UUID> {
    boolean existsById(UUID id);

    Optional<Activity> findById(UUID id);
}
