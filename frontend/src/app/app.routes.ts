import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LocationEditorComponent } from './location-editor/location-editor.component';
import { AddClientComponent } from './add-client/add-client.component';
import { DonationsComponent } from './donations/donations.component';
import { LoginComponent } from './login/login.component';
import { AuthService } from './services/auth.service';
import { inject } from '@angular/core';

export const routes: Routes = [
    { path: 'login', component: LoginComponent},
    { path: '', component: HomeComponent, canActivate: [ () => inject(AuthService).preventGuestAccess() ] },
    { path: 'create-location', component: LocationEditorComponent, canActivate: [ () => inject(AuthService).preventGuestAccess() ] },
    { path: 'edit-location/:id', component: LocationEditorComponent, canActivate: [ () => inject(AuthService).preventGuestAccess() ] },
    { path: 'add-client/:id', component: AddClientComponent, canActivate: [ () => inject(AuthService).preventGuestAccess() ]},
    { path: 'donations', component: DonationsComponent, canActivate: [ () => inject(AuthService).preventGuestAccess() ] }
];
