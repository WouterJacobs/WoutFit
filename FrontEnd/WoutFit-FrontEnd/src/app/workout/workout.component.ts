import {Component, OnInit} from '@angular/core';
import {WorkoutServiceService, IWorkout} from "../service/workout-service.service";
import {HttpClientModule} from "@angular/common/http";
import {DatePipe, NgForOf} from "@angular/common";

@Component({
  selector: 'app-workout',
  standalone: true,
  imports: [HttpClientModule, NgForOf, DatePipe],
  templateUrl: './workout.component.html',
  styleUrl: './workout.component.css'
})
export class WorkoutComponent implements OnInit {
  workouts: IWorkout[] = [];

  constructor(private workoutService: WorkoutServiceService) { }

  ngOnInit() {
    this.workoutService.getWorkouts().subscribe((data: IWorkout[]) => {
      this.workouts = data;
    });
  }

}
