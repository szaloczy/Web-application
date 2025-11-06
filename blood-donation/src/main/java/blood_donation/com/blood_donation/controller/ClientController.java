package blood_donation.com.blood_donation.controller;

import blood_donation.com.blood_donation.domain.Client;
import blood_donation.com.blood_donation.enums.GenderType;
import blood_donation.com.blood_donation.usecase.client.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class ClientController {

    private final CreateClient createClientUseCase;
    private final UpdateClient updateClientUseCase;
    private final DeleteClient deleteClientUseCase;
    private final ListClients listClientsUseCase;
    private final GetClient getClientUseCase;

    public ClientController(CreateClient createClientUseCase,
                           UpdateClient updateClientUseCase,
                           DeleteClient deleteClientUseCase,
                           ListClients listClientsUseCase,
                           GetClient getClientUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.updateClientUseCase = updateClientUseCase;
        this.deleteClientUseCase = deleteClientUseCase;
        this.listClientsUseCase = listClientsUseCase;
        this.getClientUseCase = getClientUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        try {
            List<Client> clients = listClientsUseCase.execute();
            return ResponseEntity.ok(clients);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        try {
            Client client = getClientUseCase.execute(id);
            if (client == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody ClientRequest request) {
        try {
            Client client = createClientUseCase.execute(
                request.fullname(),
                request.birthplace(),
                request.date_of_birth(),
                request.citizenship(),
                request.address(),
                request.taj_number(),
                request.gender()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(client);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateClient(@RequestBody ClientRequest request) {
        try {
            if (request.id() == null) {
                return ResponseEntity.badRequest().body("Az ID megadása kötelező");
            }
            Client client = updateClientUseCase.execute(
                request.id(),
                request.fullname(),
                request.birthplace(),
                request.date_of_birth(),
                request.citizenship(),
                request.address(),
                request.taj_number(),
                request.gender()
            );
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        try {
            deleteClientUseCase.execute(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public record ClientRequest(
        Long id,
        String fullname,
        String birthplace,
        LocalDate date_of_birth,
        String citizenship,
        String address,
        String taj_number,
        GenderType gender
    ) {}
}
