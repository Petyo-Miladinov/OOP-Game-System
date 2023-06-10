package elsys.oopprojectgame.service.impl;

import static elsys.oopprojectgame.mappers.LocationMapper.LOCATION_MAPPER;

import java.util.List;

import org.springframework.stereotype.Service;

import elsys.oopprojectgame.controllers.resources.LocationResource;
import elsys.oopprojectgame.entity.Location;
import elsys.oopprojectgame.mappers.LocationMapper;
import elsys.oopprojectgame.repository.LocationRepository;
import elsys.oopprojectgame.service.LocationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Override
    public List<LocationResource> getAllLocations() {
        return LOCATION_MAPPER.toLocationResourceList(locationRepository.findAll());
    }

    @Override
    public LocationResource getLocationById(long id) {
        return LOCATION_MAPPER.toLocationResource(locationRepository.getReferenceById((int) id));
    }

    @Override
    public LocationResource saveLocation(LocationResource resource) {
        Location Location = locationMapper.fromLocationResource(resource); 

        return LOCATION_MAPPER.toLocationResource(locationRepository.save(Location));
    }

    @Override
    public LocationResource updateLocation(long id, LocationResource resource) {
        Location toUpdate = locationRepository.getReferenceById((int) id); 
        toUpdate.setName(resource.getName());

        return LOCATION_MAPPER.toLocationResource(locationRepository.save(toUpdate));
    }

    @Override
    public boolean deleteLocation(long id) {
        locationRepository.deleteById((int) id);

        return true;
    }

    // private final LocationRepository locationRepository;

    // @Autowired
    // public LocationServiceImpl(LocationRepository locationRepository) {
    //     this.locationRepository = locationRepository;
    // }

    // @Override
    // public List<Location> getAllLocations() {
    //     return locationRepository.findAll();
    // }

    // @Override
    // public Location getLocationById(long id) {
    //     return locationRepository.findById((int) id).orElse(null);
    // }

    // @Override
    // public Location createLocation(Location location) {
    //     return locationRepository.save(location);
    // }

    // @Override
    // public Location updateLocation(long id, Location location) {
    //     Optional<Location> existingLocation = locationRepository.findById((int) id);
    //     if (existingLocation.isPresent()) {
    //         location.setId(id);
    //         return locationRepository.save(location);
    //     } else {
    //         return null;
    //     }
    // }

    // @Override
    // public boolean deleteLocation(long id) {
    //     Optional<Location> location = locationRepository.findById((int) id);
    //     if (location.isPresent()) {
    //         locationRepository.delete(location.get());
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
}
