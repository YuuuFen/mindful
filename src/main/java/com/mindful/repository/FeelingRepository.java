package com.mindful.repository;

import com.mindful.model.Feeling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeelingRepository extends JpaRepository<Feeling, Long> {
}
