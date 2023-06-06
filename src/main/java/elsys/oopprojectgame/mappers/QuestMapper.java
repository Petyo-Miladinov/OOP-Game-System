package elsys.oopprojectgame.mappers;

import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import elsys.oopprojectgame.controllers.resources.QuestResource;
import elsys.oopprojectgame.entity.Quest;

public interface QuestMapper {
    QuestMapper QUEST_MAPPER = Mappers.getMapper(QuestMapper.class);

    @Mapping(target = "id", source = "quest.id")
    Quest fromQuestResource(QuestResource questResource);

    @Mapping(target = "id", source = "quest.id")
    QuestResource toQuestResource(Quest quest);

    List<QuestResource> toQuestResourceList(List<Quest> quests);
}
