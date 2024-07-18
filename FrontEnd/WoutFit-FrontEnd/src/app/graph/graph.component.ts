// src/app/app.component.ts
import { Component, OnInit } from '@angular/core';
import { ChartConfiguration } from 'chart.js';
import {IWorkout, WorkoutServiceService} from "../service/workout-service.service";
import {BaseChartDirective} from "ng2-charts";


@Component({
  selector: 'app-graph',
  standalone: true,
  templateUrl: './graph.component.html',
  imports: [
    BaseChartDirective
  ],
  styleUrl: './graph.component.css'
})
export class GraphComponent implements OnInit {
  title = 'ng2-charts-demo';

  public barChartLegend = true;
  public barChartPlugins = [];

  public barChartData: ChartConfiguration<'bar'>['data'] = {
    labels: [],
    datasets: [
      { data: [], label: 'Calories Burned' },
      { data: [], label: 'Duration (min)' }
    ]
  };

  public barChartOptions: ChartConfiguration<'bar'>['options'] = {
    responsive: false,
  };

  constructor(private workoutService: WorkoutServiceService) { }

  ngOnInit() {
    this.workoutService.getWorkouts().subscribe((workouts: IWorkout[]) => {
      this.barChartData.labels = workouts.map(workout => workout.name);
      this.barChartData.datasets[0].data = workouts.map(workout => workout.caloriesBurned);
      this.barChartData.datasets[1].data = workouts.map(workout => workout.duration);
    });
  }
}
