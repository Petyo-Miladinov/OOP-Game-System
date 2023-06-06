package elsys.oopprojectgame.mappers;

import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import elsys.oopprojectgame.controllers.resources.LocationResource;
import elsys.oopprojectgame.entity.Location;

public interface LocationMapper {
    LocationMapper LOCATION_MAPPER = Mappers.getMapper(LocationMapper.class);

    @Mapping(target = "id", source = "id")
    Location fromLocationResource(LocationResource locationResource);

    @Mapping(target = "id", source = "id")
    LocationResource toLocationResource(Location location);

    List<LocationResource> toLocationResourceList(List<Location> locations);
}
