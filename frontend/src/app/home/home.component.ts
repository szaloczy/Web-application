import { Component, inject, OnInit } from '@angular/core';
import { LocationService } from '../services/location.service';
import { Router } from '@angular/router';
import { DashboardStatsDTO, LocationDTO, LocationStatus, UserDTO } from '../../types';
import { AuthService } from '../services/auth.service';
import { UserService } from '../services/user.service';
import { ToastService } from '../services/toast.service';
import { StatsService } from '../services/stats.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
  locationService = inject(LocationService);
  authService = inject(AuthService);
  userService = inject(UserService);
  toastService = inject(ToastService);
  statsService = inject(StatsService);
  router = inject(Router);

  locations: LocationDTO[] = [];
  users: UserDTO[] = [];
  stats: DashboardStatsDTO | null = null;
  
  LocationStatus = LocationStatus;

  ngOnInit(): void {
    this.loadStats();
    
    this.locationService.getAll().subscribe({
      next: (locations) => {
        this.locations = locations;
      },
      error: (err) => {
        console.error(err);
      }
    });

    this.userService.getAll().subscribe({
      next: (users) => {
        this.users = users;
      },
      error: (err) => {
        console.error(err);
      }
    })
  }

  loadStats(): void {
    this.statsService.getDashboardStats().subscribe({
      next: (stats) => {
        this.stats = stats;
      },
      error: (err) => {
        console.error('Error loading stats:', err);
      }
    });
  }

  deleteLocation(index: number) {
    const location = this.locations[index];

    if (location.id && confirm('Biztosan törölni szeretnéd ezt a helyszínt?')) {
      this.locationService.delete(location.id).subscribe({
        next: () => {
          this.locations.splice(index, 1);
          this.toastService.showSuccess('Helyszín sikeresen törölve');
        },
        error: (err) => {
          this.toastService.showError('Hiba történt a törlés során');
          console.error(err);
        }
      });
    }
  }

  deleteUser(index: number) {
    const user = this.users[index];

    this.userService.delete(user.id).subscribe({
      next: () => {
        this.users.splice(index, 1);
        this.toastService.showSuccess('Felhasználó sikeresen törölve');
      },
      error: (err) => {
        console.error(err);
      }
    });
  }

  navigateToAddClientForm(id: number) {
    this.router.navigate(['add-client', id]);
  }

  navigateToLocationForm(id: number) {
    this.router.navigate(['edit-location', id]);
  }

  toggleLocationStatus(locationId: number, currentStatus: LocationStatus) {
    const newStatus = currentStatus === LocationStatus.ACTIVE ? LocationStatus.INACTIVE : LocationStatus.ACTIVE;
    
    const location = this.locations.find(loc => loc.id === locationId);
    if (location && location.id) {
      const updatedLocation: LocationDTO = {
        ...location,
        status: newStatus
      };
      
      this.locationService.update(location.id, updatedLocation).subscribe({
        next: (updated) => {
          const locIndex = this.locations.findIndex(loc => loc.id === locationId);
          if (locIndex !== -1) {
            this.locations[locIndex] = updated;
          }
          this.toastService.showSuccess('Helyszín állapota frissítve');
        },
        error: (err) => {
          this.toastService.showError('Hiba az állapot frissítésekor');
          console.error('Hiba az állapot frissítésekor:', err);
        }
      });
    }
  }
}
