import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {WorkoutComponent} from "./workout/workout.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, WorkoutComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'WoutFit-FrontEnd';
}
