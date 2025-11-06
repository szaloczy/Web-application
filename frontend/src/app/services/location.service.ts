import { HttpClient, HttpParams } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { LocationDTO, LocationStatus } from '../../types';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  private readonly apiUrl = 'http://localhost:8080/api/locations';

  http = inject(HttpClient);

  getAll(filters?: {
    name?: string;
    address?: string;
    status?: LocationStatus;
  }) {
    let params = new HttpParams();

    if (filters) {
      if (filters.name) {
        params = params.set('name', filters.name);
      }
      if (filters.address) {
        params = params.set('address', filters.address);
      }
      if (filters.status) {
        params = params.set('status', filters.status);
      }
    }

    return this.http.get<LocationDTO[]>(`${this.apiUrl}`, { params });
  }

  getOne(id: number) {
    return this.http.get<LocationDTO>(`${this.apiUrl}/${id}`);
  }

  create(location: LocationDTO) {
    return this.http.post<LocationDTO>(`${this.apiUrl}`, location);
  }

  update(id: number, location: LocationDTO) {
    return this.http.put<LocationDTO>(`${this.apiUrl}/${id}`, location);
  }

  delete(id: number) {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
