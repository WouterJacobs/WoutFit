import { Routes } from '@angular/router';
import {WorkoutFormComponent} from "./add-workout/add-workout.component";
import {WorkoutComponent} from "./workout/workout.component";

export const routes: Routes = [
  { path: 'workout', component: WorkoutComponent },
  { path: 'add-workout', component: WorkoutFormComponent },
  { path: '', redirectTo: '/workout', pathMatch: 'full' }  // Default route
];
