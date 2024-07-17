package be.wouterjacobs.woutfitbackend.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest {
    private Workout workout;
    private Workout emptyWorkout;

    @BeforeEach
    void setUp() {
        workout = new Workout(
                "Morning Run",
                30,
                WorkoutType.RUN,
                LocalDate.of(2023, 7, 16),
                300,
                5.0,
                8
        );
        emptyWorkout = new Workout();
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals("Morning Run", workout.getName());
        assertEquals(30, workout.getDuration());
        assertEquals(WorkoutType.RUN, workout.getWorkoutType());
        assertEquals(LocalDate.of(2023, 7, 16), workout.getDate());
        assertEquals(300, workout.getCaloriesBurned());
        assertEquals(5.0, workout.getDistanceInKilometers());
        assertEquals(8, workout.getIntensityLevel());
    }

    @Test
    void testDefaultConstructor() {
        assertNull(emptyWorkout.getName());
        assertEquals(0, emptyWorkout.getDuration());
        assertNull(emptyWorkout.getWorkoutType());
        assertNull(emptyWorkout.getDate());
        assertEquals(0, emptyWorkout.getCaloriesBurned());
        assertNull(emptyWorkout.getDistanceInKilometers());
        assertEquals(0, emptyWorkout.getIntensityLevel());
    }

    @Test
    void assigningIntensityLevelBetween1and10AssignsProperly(){
        emptyWorkout.setIntensityLevel(1);
        assertEquals(1, emptyWorkout.getIntensityLevel());
        emptyWorkout.setIntensityLevel(10);
        assertEquals(10, emptyWorkout.getIntensityLevel());
        emptyWorkout.setIntensityLevel(5);
        assertEquals(5, emptyWorkout.getIntensityLevel());
    }
    @Test
    void assigningInvalidIntensityLevelShouldThrowException(){
        assertThrows(IllegalArgumentException.class, () -> emptyWorkout.setIntensityLevel(0));
        assertThrows(IllegalArgumentException.class, () -> emptyWorkout.setIntensityLevel(-1));
        assertThrows(IllegalArgumentException.class, () -> emptyWorkout.setIntensityLevel(11));
    }

    @Test
    void getId() {
        emptyWorkout.setId(1L);
        assertEquals(1L, emptyWorkout.getId());
    }

    @Test
    void setId() {
        emptyWorkout.setId(1L);
        assertEquals(1L, emptyWorkout.getId());
    }

    @Test
    void getName() {
        assertEquals("Morning Run", workout.getName());
    }

    @Test
    void setName() {
        emptyWorkout.setName("Evening Yoga");
        assertEquals("Evening Yoga", emptyWorkout.getName());
    }

    @Test
    void getDuration() {
        assertEquals(30, workout.getDuration());
    }

    @Test
    void setDuration() {
        emptyWorkout.setDuration(45);
        assertEquals(45, emptyWorkout.getDuration());
    }

    @Test
    void getWorkoutType() {
        assertEquals(WorkoutType.RUN, workout.getWorkoutType());
    }

    @Test
    void setWorkoutType() {
        emptyWorkout.setWorkoutType(WorkoutType.DANCE);
        assertEquals(WorkoutType.DANCE, emptyWorkout.getWorkoutType());
    }

    @Test
    void getDate() {
        assertEquals(LocalDate.of(2023, 7, 16), workout.getDate());
    }

    @Test
    void setDate() {
        emptyWorkout.setDate(LocalDate.of(2023, 7, 15));
        assertEquals(LocalDate.of(2023, 7, 15), emptyWorkout.getDate());
    }

    @Test
    void getCaloriesBurned() {
        assertEquals(300, workout.getCaloriesBurned());
    }

    @Test
    void setCaloriesBurned() {
        emptyWorkout.setCaloriesBurned(200);
        assertEquals(200, emptyWorkout.getCaloriesBurned());
    }

    @Test
    void getDistanceInKilometers() {
        assertEquals(5.0, workout.getDistanceInKilometers());
    }

    @Test
    void setDistanceInKilometers() {
        emptyWorkout.setDistanceInKilometers(3.5);
        assertEquals(3.5, emptyWorkout.getDistanceInKilometers());
    }

    @Test
    void testSetDistanceInKilometersToNull() {
        emptyWorkout.setDistanceInKilometers(null);
        assertNull(emptyWorkout.getDistanceInKilometers());
    }

    @Test
    void getIntensityLevel() {
        assertEquals(8, workout.getIntensityLevel());
    }

    @Test
    void setIntensityLevel() {
        emptyWorkout.setIntensityLevel(5);
        assertEquals(5, emptyWorkout.getIntensityLevel());
    }
}