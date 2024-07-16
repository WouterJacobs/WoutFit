package be.wouterjacobs.woutfitbackend.controller.dto;

import be.wouterjacobs.woutfitbackend.domain.WorkoutType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutDTOTest {
    private WorkoutDTO workoutDTO;
    private WorkoutDTO emptyWorkoutDTO;

    @BeforeEach
    void setUp() {
        workoutDTO = new WorkoutDTO(
                "Morning Run",
                30,
                WorkoutType.RUN,
                LocalDate.of(2023, 7, 16),
                300,
                5.0,
                8
        );
        emptyWorkoutDTO = new WorkoutDTO();
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals("Morning Run", workoutDTO.getName());
        assertEquals(30, workoutDTO.getDuration());
        assertEquals(WorkoutType.RUN, workoutDTO.getWorkoutType());
        assertEquals(LocalDate.of(2023, 7, 16), workoutDTO.getDate());
        assertEquals(300, workoutDTO.getCaloriesBurned());
        assertEquals(5.0, workoutDTO.getDistanceInKilometers());
        assertEquals(8, workoutDTO.getIntensityLevel());
    }

    @Test
    void testDefaultConstructor() {
        assertNull(emptyWorkoutDTO.getName());
        assertEquals(0, emptyWorkoutDTO.getDuration());
        assertNull(emptyWorkoutDTO.getWorkoutType());
        assertNull(emptyWorkoutDTO.getDate());
        assertEquals(0, emptyWorkoutDTO.getCaloriesBurned());
        assertNull(emptyWorkoutDTO.getDistanceInKilometers());
        assertEquals(0, emptyWorkoutDTO.getIntensityLevel());
    }

    @Test
    void getId() {
        emptyWorkoutDTO.setId(1L);
        assertEquals(1L, emptyWorkoutDTO.getId());
    }

    @Test
    void setId() {
        emptyWorkoutDTO.setId(1L);
        assertEquals(1L, emptyWorkoutDTO.getId());
    }

    @Test
    void getName() {
        assertEquals("Morning Run", workoutDTO.getName());
    }

    @Test
    void setName() {
        emptyWorkoutDTO.setName("Evening Yoga");
        assertEquals("Evening Yoga", emptyWorkoutDTO.getName());
    }

    @Test
    void getDuration() {
        assertEquals(30, workoutDTO.getDuration());
    }

    @Test
    void setDuration() {
        emptyWorkoutDTO.setDuration(45);
        assertEquals(45, emptyWorkoutDTO.getDuration());
    }

    @Test
    void getWorkoutType() {
        assertEquals(WorkoutType.RUN, workoutDTO.getWorkoutType());
    }

    @Test
    void setWorkoutType() {
        emptyWorkoutDTO.setWorkoutType(WorkoutType.DANCE);
        assertEquals(WorkoutType.DANCE, emptyWorkoutDTO.getWorkoutType());
    }

    @Test
    void getDate() {
        assertEquals(LocalDate.of(2023, 7, 16), workoutDTO.getDate());
    }

    @Test
    void setDate() {
        emptyWorkoutDTO.setDate(LocalDate.of(2023, 7, 15));
        assertEquals(LocalDate.of(2023, 7, 15), emptyWorkoutDTO.getDate());
    }

    @Test
    void getCaloriesBurned() {
        assertEquals(300, workoutDTO.getCaloriesBurned());
    }

    @Test
    void setCaloriesBurned() {
        emptyWorkoutDTO.setCaloriesBurned(200);
        assertEquals(200, emptyWorkoutDTO.getCaloriesBurned());
    }

    @Test
    void getDistanceInKilometers() {
        assertEquals(5.0, workoutDTO.getDistanceInKilometers());
    }

    @Test
    void setDistanceInKilometers() {
        emptyWorkoutDTO.setDistanceInKilometers(3.5);
        assertEquals(3.5, emptyWorkoutDTO.getDistanceInKilometers());
    }

    @Test
    void testSetDistanceInKilometersToNull() {
        emptyWorkoutDTO.setDistanceInKilometers(null);
        assertNull(emptyWorkoutDTO.getDistanceInKilometers());
    }

    @Test
    void getIntensityLevel() {
        assertEquals(8, workoutDTO.getIntensityLevel());
    }

    @Test
    void setIntensityLevel() {
        emptyWorkoutDTO.setIntensityLevel(5);
        assertEquals(5, emptyWorkoutDTO.getIntensityLevel());
    }
}