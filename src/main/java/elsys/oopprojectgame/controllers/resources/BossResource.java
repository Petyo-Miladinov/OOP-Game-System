package elsys.oopprojectgame.controllers.resources;

import java.util.List;

import elsys.oopprojectgame.entity.Item;
import elsys.oopprojectgame.entity.Location;
import elsys.oopprojectgame.entity.Quest;
import lombok.Data;

@Data
public class BossResource {
    private Long id;
    private String name;
    private int health;

    private Location location;

    private Item lootItem;

    private List<Quest> quests;
}
