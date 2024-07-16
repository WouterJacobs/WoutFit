package be.wouterjacobs.woutfitbackend.util;

import be.wouterjacobs.woutfitbackend.controller.dto.WorkoutDTO;
import be.wouterjacobs.woutfitbackend.domain.Workout;
import be.wouterjacobs.woutfitbackend.domain.WorkoutType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutConverterTest {
    private WorkoutConverter workoutConverter;

    @BeforeEach
    void setUp() {
        workoutConverter = new WorkoutConverter();
    }

    @Test
    void toWorkoutDTO() {
        Workout workout = new Workout(
                "Morning Run",
                30,
                WorkoutType.RUN,
                LocalDate.of(2023, 7, 16),
                300,
                5.0,
                8
        );
        workout.setId(1L);

        WorkoutDTO workoutDTO = workoutConverter.toWorkoutDTO(workout);

        assertEquals(1L, workoutDTO.getId());
        assertEquals("Morning Run", workoutDTO.getName());
        assertEquals(30, workoutDTO.getDuration());
        assertEquals(WorkoutType.RUN, workoutDTO.getWorkoutType());
        assertEquals(LocalDate.of(2023, 7, 16), workoutDTO.getDate());
        assertEquals(300, workoutDTO.getCaloriesBurned());
        assertEquals(5.0, workoutDTO.getDistanceInKilometers());
        assertEquals(8, workoutDTO.getIntensityLevel());
    }

    @Test
    void toWorkoutEntity() {
        WorkoutDTO workoutDTO = new WorkoutDTO(
                "Morning Run",
                30,
                WorkoutType.RUN,
                LocalDate.of(2023, 7, 16),
                300,
                5.0,
                8
        );
        workoutDTO.setId(1L);

        Workout workout = workoutConverter.toWorkoutEntity(workoutDTO);

        assertEquals("Morning Run", workout.getName());
        assertEquals(30, workout.getDuration());
        assertEquals(WorkoutType.RUN, workout.getWorkoutType());
        assertEquals(LocalDate.of(2023, 7, 16), workout.getDate());
        assertEquals(300, workout.getCaloriesBurned());
        assertEquals(5.0, workout.getDistanceInKilometers());
        assertEquals(8, workout.getIntensityLevel());
    }
}