package be.wouterjacobs.woutfitbackend.controller.api;

import be.wouterjacobs.woutfitbackend.controller.dto.WorkoutDTO;
import be.wouterjacobs.woutfitbackend.domain.Workout;
import be.wouterjacobs.woutfitbackend.domain.WorkoutType;
import be.wouterjacobs.woutfitbackend.repository.WorkoutRepository;
import be.wouterjacobs.woutfitbackend.service.WorkoutService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class WorkoutControllerTest {
    private MockMvc mockMvc;

    @Mock
    private WorkoutService workoutService;

    @InjectMocks
    private WorkoutController workoutController;
    @Mock
    private WorkoutRepository workoutRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(workoutController)
                .build();
    }

    @Test
    void getWorkouts() throws Exception {
        Workout workout1 = new Workout("Run", 30, WorkoutType.RUN, LocalDate.now(), 300, 5.0, 7);
        Workout workout2 = new Workout("Dance", 60, WorkoutType.DANCE, LocalDate.now(), 500, 2.0, 8);
        List<Workout> workouts = Arrays.asList(workout1, workout2);

        when(workoutService.getAllWorkouts()).thenReturn(workouts);

        mockMvc.perform(get("/workouts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Run"))
                .andExpect(jsonPath("$[1].name").value("Dance"));

        verify(workoutService, times(1)).getAllWorkouts();
        verifyNoMoreInteractions(workoutService);
    }

    @Test
    void getWorkoutById() throws Exception {
        Workout workout = new Workout("Run", 30, WorkoutType.RUN, LocalDate.now(), 300, 5.0, 7);
        workout.setId(1L);

        when(workoutService.getWorkoutById(1L)).thenReturn(workout);

        mockMvc.perform(get("/workouts/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Run"))
                .andExpect(jsonPath("$.duration").value(30));

        verify(workoutService, times(1)).getWorkoutById(1L);
        verifyNoMoreInteractions(workoutService);
    }

}
