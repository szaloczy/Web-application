package blood_donation.com.blood_donation.controller;

import blood_donation.com.blood_donation.domain.Location;
import blood_donation.com.blood_donation.enums.LocationStatus;
import blood_donation.com.blood_donation.usecase.location.CreateLocation;
import blood_donation.com.blood_donation.usecase.location.DeleteLocation;
import blood_donation.com.blood_donation.usecase.location.ListLocations;
import blood_donation.com.blood_donation.usecase.location.UpdateLocation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class LocationController {

    private final CreateLocation createLocationUseCase;
    private final UpdateLocation updateLocationUseCase;
    private final DeleteLocation deleteLocationUseCase;
    private final ListLocations listLocationsUseCase;

    public LocationController(CreateLocation createLocationUseCase, 
                             UpdateLocation updateLocationUseCase,
                             DeleteLocation deleteLocationUseCase, 
                             ListLocations listLocationsUseCase) {
        this.createLocationUseCase = createLocationUseCase;
        this.updateLocationUseCase = updateLocationUseCase;
        this.deleteLocationUseCase = deleteLocationUseCase;
        this.listLocationsUseCase = listLocationsUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        try {
            List<Location> locations = listLocationsUseCase.execute();
            return ResponseEntity.ok(locations);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createLocation(@RequestBody LocationRequest request) {
        try {
            Location location = createLocationUseCase.execute(
                request.name(), 
                request.address(), 
                request.status()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(location);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLocation(@PathVariable Long id, @RequestBody LocationRequest request) {
        try {
            Location location = updateLocationUseCase.execute(
                id,
                request.name(), 
                request.address(), 
                request.status()
            );
            return ResponseEntity.ok(location);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable Long id) {
        try {
            deleteLocationUseCase.execute(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public record LocationRequest(String name, String address, LocationStatus status) {}
}
