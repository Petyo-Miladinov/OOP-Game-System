package elsys.oopprojectgame.service.impl;

import static elsys.oopprojectgame.mappers.PlayerMapper.PLAYER_MAPPER;

import java.util.List;

import org.springframework.stereotype.Service;

import elsys.oopprojectgame.controllers.resources.PLayerResource;
import elsys.oopprojectgame.entity.Player;
import elsys.oopprojectgame.mappers.PlayerMapper;
import elsys.oopprojectgame.repository.PlayerRepository;
import elsys.oopprojectgame.service.PlayerService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public List<PLayerResource> getAllPlayers() {
        return PLAYER_MAPPER.toPlayerResourceList(playerRepository.findAll());
    }

    @Override
    public PLayerResource getPlayerById(long id) {
        return PLAYER_MAPPER.toPlayerResource(playerRepository.getReferenceById( (int) id));
    }

    @Override
    public PLayerResource savePlayer(PLayerResource resource) {
        Player player = playerMapper.fromPlayerResource(resource);

        return PLAYER_MAPPER.toPlayerResource(playerRepository.save(player));
    }

    @Override
    public PLayerResource updatePlayer(long id, PLayerResource resource) {
        Player toUpdate = playerRepository.getReferenceById((int) id); 
        toUpdate.setName(resource.getName());

        return PLAYER_MAPPER.toPlayerResource(playerRepository.save(toUpdate));
    }

    @Override
    public boolean deletePlayer(long id) {
        playerRepository.deleteById((int) id);

        return true;
    }
}
