package be.wouterjacobs.woutfitbackend.controller.dto;

import be.wouterjacobs.woutfitbackend.domain.WorkoutType;

public class WorkoutDTO {
    private Long id;
    private String name;
    private int duration;
    private WorkoutType workoutType;

    // Default constructor
    public WorkoutDTO() {}

    public WorkoutDTO(String name, int duration, WorkoutType workoutType) {
        this.name = name;
        this.duration = duration;
        this.workoutType = workoutType;
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
}
