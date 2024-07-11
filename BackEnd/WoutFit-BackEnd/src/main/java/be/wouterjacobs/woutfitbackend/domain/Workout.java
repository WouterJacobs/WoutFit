package be.wouterjacobs.woutfitbackend.domain;

import jakarta.persistence.*;

@Entity
public class Workout {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int duration;
    @Enumerated(EnumType.STRING)
    private WorkoutType workoutType;
}
