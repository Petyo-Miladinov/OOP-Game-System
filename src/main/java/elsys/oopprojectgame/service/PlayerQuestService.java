package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.entity.PlayerQuest;

public interface PlayerQuestService {
    List<PlayerQuest> getAllPlayerQuests();

    PlayerQuest getPlayerQuestById(long id);

    PlayerQuest createPlayerQuest(PlayerQuest playerQuest);

    PlayerQuest updatePlayerQuest(long id, PlayerQuest playerQuest);

    boolean deletePlayerQuest(long id); 
}