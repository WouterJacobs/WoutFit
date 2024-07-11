package be.wouterjacobs.woutfitbackend.service;

import be.wouterjacobs.woutfitbackend.controller.dto.WorkoutDTO;
import be.wouterjacobs.woutfitbackend.domain.Workout;
import be.wouterjacobs.woutfitbackend.repository.WorkoutRepository;
import be.wouterjacobs.woutfitbackend.util.WorkoutConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final WorkoutConverter workoutConverter;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository, WorkoutConverter workoutConverter) {
        this.workoutRepository = workoutRepository;
        this.workoutConverter = workoutConverter;
    }

    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll().stream().toList();
    }
    public Workout getWorkoutById(Long id){
        return workoutRepository.findById(id).orElseThrow();
    }
    public void addWorkout(WorkoutDTO workoutDTO){
        workoutRepository.save(workoutConverter.toWorkoutEntity(workoutDTO));
    }
}
