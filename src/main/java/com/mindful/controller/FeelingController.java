package com.mindful.controller;

import com.mindful.model.Feeling;
import com.mindful.service.FeelingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feelings")
public class FeelingController {

    private final FeelingService feelingService;

    public FeelingController(FeelingService feelingService) {
        this.feelingService = feelingService;
    }

    @GetMapping
    public ResponseEntity<List<Feeling>> getAllFeelings() {
        return ResponseEntity.ok(feelingService.getAllFeelings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feeling> getFeelingById(@PathVariable Long id) {
        Optional<Feeling> feeling = feelingService.getFeelingById(id);
        return feeling.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Feeling> createFeeling(@RequestBody Feeling feeling) {
        Feeling createdFeeling = feelingService.createFeeling(feeling);
        return ResponseEntity.ok(createdFeeling);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeeling(@PathVariable Long id) {
        feelingService.deleteFeeling(id);
        return ResponseEntity.noContent().build();
    }
}
