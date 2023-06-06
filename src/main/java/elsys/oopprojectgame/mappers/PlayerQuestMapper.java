package elsys.oopprojectgame.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import elsys.oopprojectgame.controllers.resources.PlayerQuestResource;
import elsys.oopprojectgame.entity.PlayerQuest;

public interface PlayerQuestMapper {
    PlayerQuestMapper PLAYERQUEST_Mapper = Mappers.getMapper(PlayerQuestMapper.class);

    @Mapping(target = "id", source = "playerQuest.id")
    PlayerQuest fromPlayerQuestResource(PlayerQuestResource playerQuestResource); 

    @Mapping(target = "id", source = "playerQuest.id")
    PlayerQuestResource toPlayerQuestResource(PlayerQuest playerQuest);
}
