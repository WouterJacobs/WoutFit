import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

interface IWorkout {
}

@Injectable({
  providedIn: 'root'
})
export class WorkoutServiceService {

  constructor(private http: HttpClient) { }
  getWorkouts(){
    return this.http.get<IWorkout[]>("http://localhost:8081/api/workouts");
  }
}
