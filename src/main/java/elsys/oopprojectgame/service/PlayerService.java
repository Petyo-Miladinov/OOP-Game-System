package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.entity.Player;

public interface PlayerService {
    List<Player> getAllPlayers();

    Player getPlayerById(long id);

    Player createPlayer(Player player);

    Player updatePlayer(long id, Player player);

    boolean deletePlayer(long id);
}
