package be.wouterjacobs.woutfitbackend.controller.api;

import be.wouterjacobs.woutfitbackend.controller.dto.WorkoutDTO;
import be.wouterjacobs.woutfitbackend.domain.Workout;
import be.wouterjacobs.woutfitbackend.domain.WorkoutType;
import be.wouterjacobs.woutfitbackend.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public ResponseEntity<List<Workout>> getWorkouts() {
        List<Workout> workouts = workoutService.getAllWorkouts();
        return ResponseEntity.ok(workouts);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseEntity<Void> addWorkout(@RequestBody WorkoutDTO workoutDTO) {
        workoutService.addWorkout(workoutDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable Long id) {
        Workout workout = workoutService.getWorkoutById(id);
        return ResponseEntity.ok(workout);
    }

}
