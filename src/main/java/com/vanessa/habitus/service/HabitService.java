package com.vanessa.habitus.service;

import com.vanessa.habitus.model.Habit;
import com.vanessa.habitus.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public Habit create(Habit habit) {
        habit.setCreatedDate(LocalDate.now());
        return habitRepository.save(habit);
    }

    public List<Habit> findAll() {
        return habitRepository.findAll();
    }

    public Habit findById(Long id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
        }

        public Habit update(Long id, Habit habit) {
        Habit existing = findById(id);
        existing.setName(habit.getName());
        return habitRepository.save(existing);
    }

    public void delete(Long id) {
        habitRepository.deleteById(id);
    }
}
