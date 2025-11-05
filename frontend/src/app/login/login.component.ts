import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { LoginDTO, RegisterDTO } from '../../types';
import { UserService } from '../services/user.service';
import { AuthService } from '../services/auth.service';
import { Router, RouterLink } from '@angular/router';
import { ToastService } from '../services/toast.service';

@Component({
  selector: 'app-login',
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  fb = inject(FormBuilder);
  userService = inject(UserService);
  authService = inject(AuthService);
  toastService = inject(ToastService);
  router = inject(Router);
  loginForm!: FormGroup;
  isLoginMode = true;

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      username: ['']
    });
  }

  toggleMode() {
    this.isLoginMode = !this.isLoginMode;
    
    // Dinamikus validáció: username kötelező csak regisztrációnál
    if (this.isLoginMode) {
      this.loginForm.get('username')?.clearValidators();
    } else {
      this.loginForm.get('username')?.setValidators([Validators.required, Validators.minLength(3)]);
    }
    this.loginForm.get('username')?.updateValueAndValidity();
    
    return this.isLoginMode;
  }

  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    }

    if (this.isLoginMode) {
      this.login();
    } else {
      this.register();
    }
  }

  register() {
    const registerData: RegisterDTO = {
      username: this.loginForm.value.username,
      email: this.loginForm.value.email,
      password: this.loginForm.value.password
    };

    this.userService.register(registerData).subscribe({
      next: (response) => {
        console.log('User registered successfully', response);
        this.authService.setToken(response.token);
        this.authService.setUserInfo(response.username, response.email, response.role);
        this.router.navigateByUrl('/');
        this.toastService.showSuccess('Sikeres regisztráció - Admin jogosultság');
      },
      error: (err) => {
        this.toastService.showError(err.error || 'Regisztráció sikertelen');
        console.error(err);
      }
    });
  }

  login() {
    const loginData: LoginDTO = {
      email: this.loginForm.value.email,
      password: this.loginForm.value.password
    };

    this.userService.login(loginData).subscribe({
      next: (response) => {
        this.authService.setToken(response.token);
        this.authService.setUserInfo(response.username, response.email, response.role);
        this.router.navigateByUrl('/');
        this.toastService.showSuccess('Sikeres Bejelentkezés');
      },
      error: (err) => {
        this.toastService.showError(err.error || 'Hibás email vagy jelszó');
        console.error(err);
      }
    });
  }
}
