// src/app/app.component.ts
import {AfterViewInit, Component, Inject, OnInit, PLATFORM_ID} from '@angular/core';
import { ChartConfiguration } from 'chart.js';
import {IWorkout, WorkoutServiceService} from "../service/workout-service.service";
import {BaseChartDirective} from "ng2-charts";
import {isPlatformBrowser, NgIf} from "@angular/common";



@Component({
  selector: 'app-graph',
  standalone: true,
  templateUrl: './graph.component.html',
  imports: [
    BaseChartDirective,
    NgIf
  ],
  styleUrl: './graph.component.css'
})
export class GraphComponent implements OnInit {
  isBrowser: boolean;
  public barChartLegend = true;
  public barChartPlugins = [];

  public barChartData: ChartConfiguration<'bar'>['data'] = {
    labels: [],
    datasets: [
      { data: [], label: 'Calories Burned' },
      { data: [], label: 'Duration (min)' },
      { data: [], label: 'Distance (km)' },
    ]
  };

  public barChartOptions: ChartConfiguration<'bar'>['options'] = {
    responsive: true,
  };

  constructor(
    @Inject(PLATFORM_ID) private platformId: object,
    private workoutService: WorkoutServiceService
  ) {
    this.isBrowser = isPlatformBrowser(this.platformId);
  }

  ngOnInit() {
    if (this.isBrowser) {
      this.workoutService.getWorkouts().subscribe((workouts: IWorkout[]) => {
        this.barChartData.labels = workouts.map(workout => workout.name);
        this.barChartData.datasets[0].data = workouts.map(workout => workout.caloriesBurned);
        this.barChartData.datasets[1].data = workouts.map(workout => workout.duration);
        this.barChartData.datasets[2].data = workouts.map(workout => workout.distanceInKilometers ? workout.distanceInKilometers : 0);
      });
    }
  }
}
