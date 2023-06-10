package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.controllers.resources.PlayerQuestResource;

public interface PlayerQuestService {
    // List<PlayerQuest> getAllPlayerQuests();

    // PlayerQuest getPlayerQuestById(long id);

    // PlayerQuest createPlayerQuest(PlayerQuest playerQuest);

    // PlayerQuest updatePlayerQuest(long id, PlayerQuest playerQuest);

    // boolean deletePlayerQuest(long id); 

    List<PlayerQuestResource> getAllPlayerQuests();

    PlayerQuestResource getPlayerQuestById(long id);

    PlayerQuestResource savePlayerQuest(PlayerQuestResource resource);

    //PlayerQuestResource updatePlayerQuest(long id, PlayerQuestResource PlayerQuest);

    boolean deletePlayerQuest(long id);
}