package be.wouterjacobs.woutfitbackend.util;

import be.wouterjacobs.woutfitbackend.controller.dto.WorkoutDTO;
import be.wouterjacobs.woutfitbackend.domain.Workout;
import org.springframework.stereotype.Component;

@Component
public class WorkoutConverter {
    public WorkoutDTO toWorkoutDTO(Workout workout) {
        WorkoutDTO workoutDTO = new WorkoutDTO(
                workout.getName(),
                workout.getDuration(),
                workout.getWorkoutType()
        );
        workout.setId(workout.getId());
        return workoutDTO;
    }

    public Workout toWorkoutEntity(WorkoutDTO workoutDTO) {
        return new Workout(
                workoutDTO.getName(),
                workoutDTO.getDuration(),
                workoutDTO.getWorkoutType()
        );
    }
}

