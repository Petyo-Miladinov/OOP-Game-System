package elsys.oopprojectgame.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import elsys.oopprojectgame.entity.Player;
import elsys.oopprojectgame.repository.PlayerRepository;
import elsys.oopprojectgame.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(long id) {
        return playerRepository.findById((int) id).orElse(null);
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(long id, Player player) {
        Optional<Player> existingPlayer = playerRepository.findById((int) id);
        if (existingPlayer.isPresent()) {
            player.setId(id);
            return playerRepository.save(player);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletePlayer(long id) {
        Optional<Player> player = playerRepository.findById((int) id);
        if (player.isPresent()) {
            playerRepository.delete(player.get());
            return true;
        } else {
            return false;
        }
    }
}
