package be.wouterjacobs.woutfitbackend.controller.dto;

import be.wouterjacobs.woutfitbackend.domain.WorkoutType;
import jakarta.annotation.Nullable;
import com.fasterxml.jackson.datatype.jsr310.*;

import java.time.LocalDate;

public class WorkoutDTO {
    private Long id;
    private String name;
    private int duration;
    private WorkoutType workoutType;
    private LocalDate date;
    private int caloriesBurned;
    @Nullable
    private Double distanceInKilometers;
    private int intensityLevel; // 1-10
    public WorkoutDTO() {}

    public WorkoutDTO(String name, int duration, WorkoutType workoutType, LocalDate date, int caloriesBurned,
                      @Nullable Double distanceInKilometers, int intensityLevel) {
        this.name = name;
        this.duration = duration;
        this.workoutType = workoutType;
        this.date = date;
        this.caloriesBurned = caloriesBurned;
        this.distanceInKilometers = distanceInKilometers;
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
        this.intensityLevel = intensityLevel;
    }
}
