package elsys.oopprojectgame.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import elsys.oopprojectgame.entity.Quest;
import elsys.oopprojectgame.repository.QuestRepository;
import elsys.oopprojectgame.service.QuestService;

public class QuestServiceImpl implements QuestService {
    private final QuestRepository questRepository;

    @Autowired
    public QuestServiceImpl(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    @Override
    public List<Quest> getAllQuests() {
        return questRepository.findAll();
    }

    @Override
    public Quest getQuestById(long id) {
        return questRepository.findById((int) id).orElse(null);
    }

    @Override
    public Quest createQuest(Quest quest) {
        return questRepository.save(quest);
    }

    @Override
    public Quest updateQuest(long id, Quest quest) {
        Optional<Quest> existingQuest = questRepository.findById((int) id);
        if (existingQuest.isPresent()) {
            quest.setId(id);
            return questRepository.save(quest);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteQuest(long id) {
        Optional<Quest> quest = questRepository.findById((int) id);
        if (quest.isPresent()) {
            questRepository.delete(quest.get());
            return true;
        } else {
            return false;
        }
    }
}
