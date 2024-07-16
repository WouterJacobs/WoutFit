package be.wouterjacobs.woutfitbackend.config;

import be.wouterjacobs.woutfitbackend.domain.Workout;
import be.wouterjacobs.woutfitbackend.domain.WorkoutType;
import be.wouterjacobs.woutfitbackend.repository.WorkoutRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

@Configuration
public class DataInitializer {
    private final WorkoutRepository workoutRepository;

    @Autowired
    public DataInitializer(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @PostConstruct
    public void initData() {
        Workout workout1 = new Workout();
        workout1.setName("Morning Run");
        workout1.setDuration(30);
        workout1.setWorkoutType(WorkoutType.RUN);
        workout1.setDate(LocalDate.of(2024, Month.JULY,7));
        workout1.setCaloriesBurned(468);
        workout1.setDistanceInKilometers(5.);
        workout1.setIntensityLevel(7);

        Workout workout2 = new Workout();
        workout2.setName("Dance Practice");
        workout2.setDuration(120);
        workout2.setWorkoutType(WorkoutType.DANCE);
        workout2.setDate(LocalDate.of(2024, Month.JULY,11));
        workout2.setCaloriesBurned(983);
        workout2.setDistanceInKilometers(null);
        workout2.setIntensityLevel(8);

        Workout workout3 = new Workout();
        workout3.setName("Evening Jog");
        workout3.setDuration(45);
        workout3.setWorkoutType(WorkoutType.JOG);
        workout3.setDate(LocalDate.of(2024, Month.JULY,16));
        workout3.setCaloriesBurned(359);
        workout3.setDistanceInKilometers(3.6);
        workout3.setIntensityLevel(4);

        workoutRepository.save(workout1);
        workoutRepository.save(workout2);
        workoutRepository.save(workout3);
    }
}
