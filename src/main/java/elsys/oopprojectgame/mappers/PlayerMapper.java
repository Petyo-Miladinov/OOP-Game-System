package elsys.oopprojectgame.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import elsys.oopprojectgame.controllers.resources.PLayerResource;
import elsys.oopprojectgame.entity.Player;

@Mapper
public interface PlayerMapper {
    PlayerMapper PLAYER_MAPPER = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "id", source = "PlayerResource.id")
    Player fromPlayerResource(PLayerResource PlayerResource);

    @Mapping(target = "id", source = "Player.id")
    PLayerResource toPlayerResource(Player Player);

    List<PLayerResource> toPlayerResourceList(List<Player> Players);
}
