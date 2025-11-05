import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { LocationDTO } from '../../types';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  private readonly apiUrl = 'http://localhost:8080/api/locations';

  http = inject(HttpClient);

  getAll() {
    return this.http.get<LocationDTO[]>(`${this.apiUrl}`);
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
