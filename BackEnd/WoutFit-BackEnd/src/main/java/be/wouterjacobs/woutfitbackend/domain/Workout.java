package be.wouterjacobs.woutfitbackend.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Workout {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int duration;
    @Enumerated(EnumType.STRING)
    private WorkoutType workoutType;
    private LocalDate date;
    private int caloriesBurned;
    @Nullable
    private Double distanceInKilometers;
    private int intensityLevel;

    public Workout(String name, int duration, WorkoutType workoutType, LocalDate date, int caloriesBurned,
                   @Nullable Double distanceInKilometers, int intensityLevel) {
        this.name = name;
        this.duration = duration;
        this.workoutType = workoutType;
        this.date = date;
        this.caloriesBurned = caloriesBurned;
        this.distanceInKilometers = distanceInKilometers;
        assignIntensityLevel(intensityLevel);
    }
    public Workout(){}

    private void assignIntensityLevel(int intensityLevel){
        if (intensityLevel < 1 || intensityLevel > 10){
            throw new IllegalArgumentException("The intensity level must be between 1 and 10 including.");
        }
        this.intensityLevel = intensityLevel;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(WorkoutType workoutType) {
        this.workoutType = workoutType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    @Nullable
    public Double getDistanceInKilometers() {
        return distanceInKilometers;
    }

    public void setDistanceInKilometers(@Nullable Double distanceInKilometers) {
        this.distanceInKilometers = distanceInKilometers;
    }

    public int getIntensityLevel() {
        return intensityLevel;
    }

    public void setIntensityLevel(int intensityLevel) {
        assignIntensityLevel(intensityLevel);
    }
}
