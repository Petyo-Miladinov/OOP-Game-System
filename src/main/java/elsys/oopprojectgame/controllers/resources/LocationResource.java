package elsys.oopprojectgame.controllers.resources;

import java.util.List;

import elsys.oopprojectgame.entity.Location;
import lombok.Data;

@Data
public class LocationResource {
    private Long id;
    private String name;
    private String description; 

    private List<Location> locations;
}
