package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.entity.Location;

public interface LocationService {
    List<Location> getAllLocations();

    Location getLocationById(long id);

    Location createLocation(Location location);

    Location updateLocation(long id, Location location);

    boolean deleteLocation(long id);
}
