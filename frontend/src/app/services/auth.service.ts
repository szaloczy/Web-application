import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private TOKEN_KEY = 'accessToken';
  private USERNAME_KEY = 'username';
  private EMAIL_KEY = 'email';
  private ROLE_KEY = 'role';
  router = inject(Router);

  setToken(token: string) {
    localStorage.setItem(this.TOKEN_KEY, token);
  }

  getToken(): string | null {
    return localStorage.getItem(this.TOKEN_KEY)
  }

  setUserInfo(username: string, email: string, role: string) {
    localStorage.setItem(this.USERNAME_KEY, username);
    localStorage.setItem(this.EMAIL_KEY, email);
    localStorage.setItem(this.ROLE_KEY, role);
  }

  getUserInfo() {
    return {
      username: localStorage.getItem(this.USERNAME_KEY),
      email: localStorage.getItem(this.EMAIL_KEY),
      role: localStorage.getItem(this.ROLE_KEY)
    };
  }

  removeToken() {
    localStorage.removeItem(this.TOKEN_KEY);
    localStorage.removeItem(this.USERNAME_KEY);
    localStorage.removeItem(this.EMAIL_KEY);
    localStorage.removeItem(this.ROLE_KEY);
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  preventGuestAccess(): boolean {
    const isLoggedIn = this.isLoggedIn();

    if (!isLoggedIn) {
      this.router.navigateByUrl('/login');
    }
    return isLoggedIn;
  }

  getUserName(): string {
    const username = localStorage.getItem(this.USERNAME_KEY);
    if (username) return username;
    
    // Fallback: decode from token
    return this.decodeToken()?.sub || 'Ismeretlen';
  }
  
  getUserRole(): string {
    const role = localStorage.getItem(this.ROLE_KEY);
    if (role) {
      switch (role) {
        case 'ADMIN': return 'Adminisztrátor';
        case 'USER': return 'Önkéntes';
        default: return 'Ismeretlen';
      }
    }
    
    // Fallback: decode from token
    const token = this.getToken();
    switch (this.decodeToken()?.role) {
      case 'ADMIN': 
      case 'admin': return 'Adminisztrátor';
      case 'USER':
      case 'user': return 'Önkéntes';
      default: return 'Ismeretlen';
    }
  }

  isAdmin(): boolean {
    const role = localStorage.getItem(this.ROLE_KEY);
    if (role) {
      return role === 'ADMIN';
    }
    
    // Fallback: decode from token
    const decodedRole = this.decodeToken()?.role;
    return decodedRole === 'ADMIN' || decodedRole === 'admin';
  }
  
  decodeToken(): any {
    const token = this.getToken();
    if (!token) return null;
    try {
      return JSON.parse(atob(token.split('.')[1]));
    } catch (e) {
      return null;
    }
  }
}
