package com.vanessa.habitus.controller;

import com.vanessa.habitus.model.Habit;
import com.vanessa.habitus.service.HabitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @PostMapping
    public ResponseEntity<Habit> create(@RequestBody Habit habit) {
        return ResponseEntity.ok(habitService.create(habit));
    }

    @GetMapping
    public ResponseEntity<List<Habit>> findAll() {
        return ResponseEntity.ok(habitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habit> findById(@PathVariable Long id) {
        return ResponseEntity.ok(habitService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habit> update(@PathVariable Long id, @RequestBody Habit habit) {
        return ResponseEntity.ok(habitService.update(id, habit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        habitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
