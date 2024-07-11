package be.wouterjacobs.woutfitbackend.repository;

import be.wouterjacobs.woutfitbackend.domain.Workout;
import be.wouterjacobs.woutfitbackend.domain.WorkoutType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
