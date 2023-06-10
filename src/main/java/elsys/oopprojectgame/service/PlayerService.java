package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.controllers.resources.PLayerResource;

public interface PlayerService {
    // List<Player> getAllPlayers();

    // Player getPlayerById(long id);

    // Player createPlayer(Player player);

    // Player updatePlayer(long id, Player player);

    // boolean deletePlayer(long id);

    List<PLayerResource> getAllPlayers();

    PLayerResource getPlayerById(long id);

    PLayerResource savePlayer(PLayerResource resource);

    PLayerResource updatePlayer(long id, PLayerResource Player);

    boolean deletePlayer(long id);
}
