package be.wouterjacobs.woutfitbackend.config;

import be.wouterjacobs.woutfitbackend.domain.Workout;
import be.wouterjacobs.woutfitbackend.domain.WorkoutType;
import be.wouterjacobs.woutfitbackend.repository.WorkoutRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

        Workout workout2 = new Workout();
        workout2.setName("Evening Jog");
        workout2.setDuration(45);
        workout2.setWorkoutType(WorkoutType.JOG);

        workoutRepository.save(workout1);
        workoutRepository.save(workout2);
    }
}
