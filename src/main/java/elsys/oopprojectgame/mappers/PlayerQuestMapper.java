package elsys.oopprojectgame.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import elsys.oopprojectgame.controllers.resources.PlayerQuestResource;
import elsys.oopprojectgame.entity.PlayerQuest;

@Mapper
public interface PlayerQuestMapper {
    PlayerQuestMapper PLAYERQUEST_MAPPER = Mappers.getMapper(PlayerQuestMapper.class);

    @Mapping(target = "id", source = "playerQuestResource.id")
    PlayerQuest fromPlayerQuestResource(PlayerQuestResource playerQuestResource); 

    @Mapping(target = "id", source = "playerQuest.id")
    PlayerQuestResource toPlayerQuestResource(PlayerQuest playerQuest);

    List<PlayerQuestResource> toPlayerQuestResourceList(List<PlayerQuest> playerQuests); 
}
