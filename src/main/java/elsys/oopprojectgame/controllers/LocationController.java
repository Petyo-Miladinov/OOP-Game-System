package elsys.oopprojectgame.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import elsys.oopprojectgame.controllers.resources.LocationResource;
import elsys.oopprojectgame.service.LocationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/locations") 
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<?> getAll(@PathVariable long id) {
        return ResponseEntity.ok(locationService.getLocationById(id)); 
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody LocationResource resource) {
        LocationResource saved = locationService.saveLocation(resource); 

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/bosses/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);  
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody LocationResource resource) {
        return ResponseEntity.ok(locationService.updateLocation(id, resource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        locationService.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }
}
