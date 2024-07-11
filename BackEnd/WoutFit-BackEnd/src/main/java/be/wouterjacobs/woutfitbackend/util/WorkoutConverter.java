package be.wouterjacobs.woutfitbackend.util;

import be.wouterjacobs.woutfitbackend.controller.dto.WorkoutDTO;
import be.wouterjacobs.woutfitbackend.domain.Workout;

public class WorkoutConverter {
    public static WorkoutDTO toWorkoutDTO(Workout workout) {
        return new WorkoutDTO(
                workout.getId(),
                workout.getName(),
                workout.getDuration(),
                workout.getWorkoutType()
        );
    }

    public static Workout toEntity(WorkoutDTO workoutDTO) {
        Workout workout = new Workout(
                workoutDTO.getName(),
                workoutDTO.getDuration(),
                workoutDTO.getWorkoutType()
        );
        workout.setId(workoutDTO.getId());
        return workout;
    }
}

