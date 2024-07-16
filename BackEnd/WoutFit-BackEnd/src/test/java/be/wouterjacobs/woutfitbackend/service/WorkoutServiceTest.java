package be.wouterjacobs.woutfitbackend.service;

import be.wouterjacobs.woutfitbackend.controller.dto.WorkoutDTO;
import be.wouterjacobs.woutfitbackend.domain.Workout;
import be.wouterjacobs.woutfitbackend.domain.WorkoutType;
import be.wouterjacobs.woutfitbackend.repository.WorkoutRepository;
import be.wouterjacobs.woutfitbackend.util.WorkoutConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WorkoutServiceTest {
    @Mock
    private WorkoutRepository workoutRepository;

    @Mock
    private WorkoutConverter workoutConverter;

    @InjectMocks
    private WorkoutService workoutService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllWorkouts() {
        Workout workout1 = new Workout("Run", 30, WorkoutType.RUN, LocalDate.now(),
                300, 5.0, 7);
        Workout workout2 = new Workout("Jog", 60, WorkoutType.JOG, LocalDate.now(),
                500, 2.0, 8);
        List<Workout> workouts = Arrays.asList(workout1, workout2);

        when(workoutRepository.findAll()).thenReturn(workouts);

        List<Workout> result = workoutService.getAllWorkouts();

        assertEquals(2, result.size());
        verify(workoutRepository, times(1)).findAll();
    }

    @Test
    void getWorkoutById() {
        Workout workout = new Workout("Run", 30, WorkoutType.RUN, LocalDate.now(), 300, 5.0, 7);
        when(workoutRepository.findById(1L)).thenReturn(Optional.of(workout));

        Workout result = workoutService.getWorkoutById(1L);

        assertNotNull(result);
        assertEquals("Run", result.getName());
        verify(workoutRepository, times(1)).findById(1L);
    }

    @Test
    void getWorkoutById_NotFound() {
        when(workoutRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> workoutService.getWorkoutById(1L));
        verify(workoutRepository, times(1)).findById(1L);
    }

    @Test
    void addWorkout() {
        WorkoutDTO workoutDTO = new WorkoutDTO("Run", 30, WorkoutType.RUN, LocalDate.now(), 300, 5.0, 7);
        Workout workout = new Workout("Run", 30, WorkoutType.RUN, LocalDate.now(), 300, 5.0, 7);

        when(workoutConverter.toWorkoutEntity(workoutDTO)).thenReturn(workout);

        workoutService.addWorkout(workoutDTO);

        verify(workoutRepository, times(1)).save(workout);
    }

}