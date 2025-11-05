package blood_donation.com.blood_donation.controller;

import blood_donation.com.blood_donation.domain.User;
import blood_donation.com.blood_donation.usecase.user.Login;
import blood_donation.com.blood_donation.usecase.user.Register;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {

    private final Register registerUserCase;
    private final Login loginUseCase;

    public UserController(Register registerUserCase, Login loginUseCase) {
        this.registerUserCase = registerUserCase;
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/user")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = registerUserCase.register(user.username(), user.email(), user.password());
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody String email, String password) {
        Boolean response = this.loginUseCase.login(email, password);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hello")
    public String hello() {
        return "<h1>Hello</h1>";
    }
}
