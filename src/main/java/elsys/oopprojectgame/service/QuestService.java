package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.controllers.resources.QuestResource;

public interface QuestService {
    // List<Quest> getAllQuests();

    // Quest getQuestById(long id);

    // Quest createQuest(Quest quest);

    // Quest updateQuest(long id, Quest quest);

    // boolean deleteQuest(long id);

    List<QuestResource> getAllQuests();

    QuestResource getQuestById(long id);

    QuestResource saveQuest(QuestResource resource);

    QuestResource updateQuest(long id, QuestResource Quest);

    boolean deleteQuest(long id);
}
