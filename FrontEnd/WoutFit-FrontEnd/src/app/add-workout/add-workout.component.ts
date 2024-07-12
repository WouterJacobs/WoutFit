import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {IWorkout, WorkoutServiceService, WorkoutType} from "../service/workout-service.service";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-add-workout',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgForOf
  ],
  templateUrl: './add-workout.component.html',
  styleUrl: './add-workout.component.css'
})

export class WorkoutFormComponent implements OnInit {
  workoutForm!: FormGroup;
  workoutTypes = Object.values(WorkoutType);

  constructor(private fb: FormBuilder, private workoutService: WorkoutServiceService) { }

  ngOnInit(): void {
    this.workoutForm = this.fb.group({
      name: ['', Validators.required],
      duration: ['', [Validators.required, Validators.min(1)]],
      workoutType: [this.workoutTypes[0], Validators.required]
    });
  }

  onSubmit(): void {
    if (this.workoutForm.valid) {
      const newWorkout: any = {
        id: 0, // backend should generate the ID
        ...this.workoutForm.value
      };

      this.workoutService.addWorkout(newWorkout).subscribe(response => {
        console.log('Workout added successfully:', response);
        // You can optionally reset the form after successful submission
        this.workoutForm.reset();
      }, error => {
        console.error('Error adding workout:', error);
        // Handle any errors from the service call
      });
    }
  }
}
