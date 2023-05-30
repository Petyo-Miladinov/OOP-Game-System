package elsys.oopprojectgame.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import elsys.oopprojectgame.entity.Location;
import elsys.oopprojectgame.repository.LocationRepository;
import elsys.oopprojectgame.service.LocationService;

public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(long id) {
        return locationRepository.findById((int) id).orElse(null);
    }

    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(long id, Location location) {
        Optional<Location> existingLocation = locationRepository.findById((int) id);
        if (existingLocation.isPresent()) {
            location.setId(id);
            return locationRepository.save(location);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteLocation(long id) {
        Optional<Location> location = locationRepository.findById((int) id);
        if (location.isPresent()) {
            locationRepository.delete(location.get());
            return true;
        } else {
            return false;
        }
    }
}
