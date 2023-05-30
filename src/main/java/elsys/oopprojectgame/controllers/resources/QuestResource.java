package elsys.oopprojectgame.controllers.resources;

import java.util.List;

import elsys.oopprojectgame.entity.Item;
import elsys.oopprojectgame.entity.Location;
import elsys.oopprojectgame.entity.Quest;
import lombok.Data;

@Data
public class QuestResource {
    private Long id;
    private String name;
    private String description;
    private Location startLocation;
    private Location endLocation;
    private Item rewardItem;
    private List<Quest> quests;
}
