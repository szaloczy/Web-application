package blood_donation.com.blood_donation.controller;

import blood_donation.com.blood_donation.domain.Donation;
import blood_donation.com.blood_donation.usecase.donation.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/donation")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class DonationController {

    private final CreateDonation createDonationUseCase;
    private final UpdateDonation updateDonationUseCase;
    private final DeleteDonation deleteDonationUseCase;
    private final ListDonations listDonationsUseCase;
    private final GetDonation getDonationUseCase;

    public DonationController(CreateDonation createDonationUseCase,
                             UpdateDonation updateDonationUseCase,
                             DeleteDonation deleteDonationUseCase,
                             ListDonations listDonationsUseCase,
                             GetDonation getDonationUseCase) {
        this.createDonationUseCase = createDonationUseCase;
        this.updateDonationUseCase = updateDonationUseCase;
        this.deleteDonationUseCase = deleteDonationUseCase;
        this.listDonationsUseCase = listDonationsUseCase;
        this.getDonationUseCase = getDonationUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Donation>> getAllDonations(
            @RequestParam(required = false) Long clientId,
            @RequestParam(required = false) Long locationId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
        try {
            List<Donation> donations = listDonationsUseCase.execute(clientId, locationId, fromDate, toDate);
            return ResponseEntity.ok(donations);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDonationById(@PathVariable Long id) {
        try {
            Donation donation = getDonationUseCase.execute(id);
            if (donation == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(donation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createDonation(@RequestBody DonationRequest request) {
        try {
            Donation donation = createDonationUseCase.execute(
                request.date(),
                request.eligible(),
                request.reason(),
                request.doctor(),
                request.controlled(),
                request.patient_fullname(),
                request.patient_taj(),
                request.client(),
                request.location()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(donation);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateDonation(@RequestBody DonationRequest request) {
        try {
            if (request.id() == null) {
                return ResponseEntity.badRequest().body("Az ID megadása kötelező");
            }
            Donation donation = updateDonationUseCase.execute(
                request.id(),
                request.date(),
                request.eligible(),
                request.reason(),
                request.doctor(),
                request.controlled(),
                request.patient_fullname(),
                request.patient_taj(),
                request.client(),
                request.location()
            );
            return ResponseEntity.ok(donation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDonation(@PathVariable Long id) {
        try {
            deleteDonationUseCase.execute(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public record DonationRequest(
        Long id,
        LocalDate date,
        boolean eligible,
        String reason,
        String doctor,
        boolean controlled,
        String patient_fullname,
        String patient_taj,
        Long client,
        Long location
    ) {}
}
