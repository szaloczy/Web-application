package blood_donation.com.blood_donation.controller;

import blood_donation.com.blood_donation.domain.User;
import blood_donation.com.blood_donation.usecase.user.Register;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {

    private final Register registerUserCase;

    public UserController(Register registerUserCase) {
        this.registerUserCase = registerUserCase;
    }

    @PostMapping("/user")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = registerUserCase.register(user.username(), user.email(), user.password());
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/hello")
    public String hello() {
        return "<h1>Hello</h1>";
    }
}
