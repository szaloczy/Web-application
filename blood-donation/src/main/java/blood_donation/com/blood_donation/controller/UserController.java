package blood_donation.com.blood_donation.controller;

import blood_donation.com.blood_donation.domain.User;
import blood_donation.com.blood_donation.dto.LoginRequestDTO;
import blood_donation.com.blood_donation.dto.LoginResponseDTO;
import blood_donation.com.blood_donation.usecase.user.Login;
import blood_donation.com.blood_donation.usecase.user.Register;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class UserController {

    private final Register registerUseCase;
    private final Login loginUseCase;

    public UserController(Register registerUseCase, Login loginUseCase) {
        this.registerUseCase = registerUseCase;
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            LoginResponseDTO response = registerUseCase.register(
                user.username(), 
                user.email(), 
                user.password()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        try {
            LoginResponseDTO response = this.loginUseCase.login(loginRequest.getEmail(), loginRequest.getPassword());

            if (response != null) {
                return ResponseEntity.ok(response);
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Hibás email vagy jelszó");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong: " + e.getMessage());
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "<h1>Hello</h1>";
    }
}
