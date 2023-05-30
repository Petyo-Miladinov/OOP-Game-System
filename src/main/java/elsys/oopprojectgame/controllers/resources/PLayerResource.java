package elsys.oopprojectgame.controllers.resources;

import java.util.List;

import elsys.oopprojectgame.entity.Item;
import elsys.oopprojectgame.entity.Player;
import lombok.Data;

@Data
public class PLayerResource {
    private int id; 
    private String name;
    private int currentLocationId;
    private int health;
    private List<Item> items; 
    private List<Player> players; 
}
