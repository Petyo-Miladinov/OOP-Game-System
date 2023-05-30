package elsys.oopprojectgame.controllers.resources;

import java.util.List;

import elsys.oopprojectgame.entity.Item;
import elsys.oopprojectgame.entity.Location;
import elsys.oopprojectgame.entity.Player;
import lombok.Data;

@Data
public class ItemResource {
    private Long id;
    private String name;
    private String description;

    private Location location; 

    private Player player;

    private List<Item> items;
}
