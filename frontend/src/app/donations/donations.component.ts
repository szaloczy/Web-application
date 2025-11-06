import { Component, inject, OnInit } from '@angular/core';
import { LocationService } from '../services/location.service';
import { ClientDTO, DonationDTO, LocationDTO } from '../../types';
import { ClientService } from '../services/client.service';
import { DonationService } from '../services/donation.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-donations',
  imports: [
    FormsModule,
    CommonModule
  ],
  templateUrl: './donations.component.html',
  styleUrl: './donations.component.css'
})
export class DonationsComponent implements OnInit {

  locationService = inject(LocationService);
  clientService = inject(ClientService);
  donationService = inject(DonationService);

  locations: LocationDTO[] = [];
  clients: ClientDTO[] = [];
  donations: DonationDTO[] = [];

  filter = {
    locationId: '',
    clientId: '',
    fromDate: '',
    toDate: ''
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.locationService.getAll().subscribe({
      next: (locations) => {
        this.locations = locations;
        console.log('Locations loaded:', this.locations);
        this.loadClients();
      },
      error: (err) => {
        console.error(err);
      }
    });
  }

  loadClients(): void {
    this.clientService.getAll().subscribe({
      next: (clients) => {
        this.clients = clients;
        console.log('Clients loaded:', this.clients);
        this.loadDonations();
      },
      error: (err) => {
        console.error(err);
      }
    });
  }

  loadDonations(): void {
    this.donationService.getAll().subscribe({
      next: (donations) => {
        console.log('Donations received:', donations);
        console.log('First donation:', donations[0]);
        console.log('First donation client:', donations[0]?.client);
        console.log('First donation location:', donations[0]?.location);
        this.donations = donations;
      },
      error: (err) => {
        console.error('Error loading donations:', err);
      }
    });
  }

  onFilter() {
    const { locationId, clientId, fromDate, toDate } = this.filter;

    this.donationService.getAll({
      locationId: locationId ? +locationId : undefined,
      clientId: clientId ? +clientId : undefined,
      fromDate: fromDate || undefined,
      toDate: toDate || undefined
    }).subscribe({
      next: (donations) => {
        this.donations = donations;
      },
      error: (err) => {
        console.error(err);
      }
    });
  }

  getClientName(donation: DonationDTO): string {
    return donation.client?.fullname || `ID: ${donation.clientId}`;
  }

  getLocationName(donation: DonationDTO): string {
    return donation.location?.name || `ID: ${donation.locationId}`;
  }

}
