package elsys.oopprojectgame.controllers.resources;

import java.util.List;

import elsys.oopprojectgame.entity.Player;
import elsys.oopprojectgame.entity.PlayerQuest;
import elsys.oopprojectgame.entity.Quest;
import lombok.Data;

@Data
public class PlayerQuestResource {
    private Long id;
    private Player player;
    private Quest quest;
    private String status;
    //private String name; 
    private List<PlayerQuest> playerQuests;
}
