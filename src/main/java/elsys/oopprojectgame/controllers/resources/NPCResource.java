package elsys.oopprojectgame.controllers.resources;

import java.util.List;

import elsys.oopprojectgame.entity.Location;
import elsys.oopprojectgame.entity.NPC;
import elsys.oopprojectgame.entity.Quest;
import lombok.Data;

@Data
public class NPCResource {
    private Long id;
    private String name;
    private String description;
    private Location location;
    private Quest quest;
    private List<NPC> npcs;
}
