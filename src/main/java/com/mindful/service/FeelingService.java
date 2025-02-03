package com.mindful.service;

import com.mindful.model.Feeling;
import com.mindful.repository.FeelingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FeelingService {

    private final FeelingRepository feelingRepository;

    public FeelingService(FeelingRepository feelingRepository) {
        this.feelingRepository = feelingRepository;
    }

    public List<Feeling> getAllFeelings() {
        return feelingRepository.findAll();
    }

    public Optional<Feeling> getFeelingById(Long id) {
        return feelingRepository.findById(id);
    }

    public Feeling createFeeling(Feeling feeling) {
        return feelingRepository.save(feeling);
    }

    public void deleteFeeling(Long id) {
        feelingRepository.deleteById(id);
    }
}
