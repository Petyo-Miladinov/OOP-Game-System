package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.entity.Quest;

public interface QuestService {
    List<Quest> getAllQuests();

    Quest getQuestById(long id);

    Quest createQuest(Quest quest);

    Quest updateQuest(long id, Quest quest);

    boolean deleteQuest(long id);
}
