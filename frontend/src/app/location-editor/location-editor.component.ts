import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LocationService } from '../services/location.service';
import { LocationDTO, LocationStatus } from '../../types';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ToastService } from '../services/toast.service';

@Component({
  selector: 'app-location-editor',
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './location-editor.component.html',
  styleUrl: './location-editor.component.css'
})
export class LocationEditorComponent implements OnInit {
  locationService = inject(LocationService);
  activatedRoute = inject(ActivatedRoute);
  toastService = inject(ToastService);
  router = inject(Router);
  formBuilder = inject(FormBuilder);
  locationForm!: FormGroup;

  location: LocationDTO | null = null;
  isNewLocation = true;
  
  LocationStatus = LocationStatus;

  ngOnInit(): void {
    const locationId = this.activatedRoute.snapshot.params['id'];

    this.locationForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      address: ['', [Validators.required]],
      status: [LocationStatus.ACTIVE, [Validators.required]]
    });

    if (locationId) {
      this.isNewLocation = false;
      this.locationService.getOne(locationId).subscribe({
        next: (location) => {
          this.location = location;
          this.locationForm.patchValue({
            name: location.name,
            address: location.address,
            status: location.status
          });
        },
        error: (err) => {
          this.router.navigateByUrl('/');
          this.toastService.showError('Helyszín nem található');
          console.error(err);
        }
      });
    }
  }

  saveLocation() {
    if (this.locationForm.invalid) {
      return;
    }

    const locationData: LocationDTO = this.locationForm.value;

    if (this.isNewLocation) {
      this.locationService.create(locationData).subscribe({
        next: () => {
          this.router.navigateByUrl('/');
          this.toastService.showSuccess('Helyszín létrehozása sikeres');
        },
        error: (err) => {
          this.toastService.showError(err.error || 'Hiba történt a létrehozás során');
          console.error(err);
        }
      });
    } else {
      if (this.location?.id) {
        this.locationService.update(this.location.id, locationData).subscribe({
          next: () => {
            this.router.navigateByUrl('/');
            this.toastService.showSuccess('Helyszín módosítás sikeres');
          },
          error: (err) => {
            this.toastService.showError(err.error || 'Hiba történt a módosítás során');
            console.error(err);
          }
        });
      }
    }
  }
  
  deleteLocation() {
    if (this.location?.id && confirm('Biztosan törölni szeretnéd ezt a helyszínt?')) {
      this.locationService.delete(this.location.id).subscribe({
        next: () => {
          this.router.navigateByUrl('/');
          this.toastService.showSuccess('Helyszín törlése sikeres');
        },
        error: (err) => {
          this.toastService.showError(err.error || 'Hiba történt a törlés során');
          console.error(err);
        }
      });
    }
  }
}
