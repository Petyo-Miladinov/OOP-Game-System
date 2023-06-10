package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.controllers.resources.LocationResource;

public interface LocationService {
    // List<Location> getAllLocations();

    // Location getLocationById(long id);

    // // Location createLocation(Location location);

    // Location sLocation(Location location);

    // Location updateLocation(long id, Location location);

    // boolean deleteLocation(long id);

    List<LocationResource> getAllLocations();

    LocationResource getLocationById(long id);

    LocationResource saveLocation(LocationResource resource);

    LocationResource updateLocation(long id, LocationResource Location);

    boolean deleteLocation(long id);
}
