import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export enum WorkoutType {
  RUN = 'RUN',
  JOG = 'JOG',
  DANCE = 'DANCE'
}

export interface IWorkout {
  id: number;
  name: string;
  duration: number;
  workoutType: WorkoutType;
}

@Injectable({
  providedIn: 'root'
})
export class WorkoutServiceService {
  private apiUrl = 'http://localhost:8081/workouts';

  constructor(private http: HttpClient) { }

  getWorkouts(): Observable<IWorkout[]> {
    return this.http.get<IWorkout[]>(this.apiUrl);
  }

  addWorkout(workout: IWorkout): Observable<IWorkout> {
    return this.http.post<IWorkout>(this.apiUrl, workout);
  }
}
