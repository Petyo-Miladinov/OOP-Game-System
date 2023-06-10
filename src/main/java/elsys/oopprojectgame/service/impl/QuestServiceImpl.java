package elsys.oopprojectgame.service.impl;

import static elsys.oopprojectgame.mappers.QuestMapper.QUEST_MAPPER;

import java.util.List;

import org.springframework.stereotype.Service;

import elsys.oopprojectgame.controllers.resources.QuestResource;
import elsys.oopprojectgame.entity.Quest;
import elsys.oopprojectgame.mappers.QuestMapper;
import elsys.oopprojectgame.repository.QuestRepository;
import elsys.oopprojectgame.service.QuestService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestServiceImpl implements QuestService {
    private final QuestRepository questRepository;
    private final QuestMapper questMapper;

    @Override
    public List<QuestResource> getAllQuests() {
        return QUEST_MAPPER.toQuestResourceList(questRepository.findAll());
    }

    @Override
    public QuestResource getQuestById(long id) {
        return QUEST_MAPPER.toQuestResource(questRepository.getReferenceById((int) id));
    }

    @Override
    public QuestResource saveQuest(QuestResource resource) {
        Quest Quest = questMapper.fromQuestResource(resource); 

        return QUEST_MAPPER.toQuestResource(questRepository.save(Quest));
    }

    @Override
    public QuestResource updateQuest(long id, QuestResource resource) {
        Quest toUpdate = questRepository.getReferenceById((int) id); 
        toUpdate.setName(resource.getName());

        return QUEST_MAPPER.toQuestResource(questRepository.save(toUpdate));
    }

    @Override
    public boolean deleteQuest(long id) {
        questRepository.deleteById((int) id);

        return true;
    }

    // @Autowired
    // public QuestServiceImpl(QuestRepository questRepository) {
    //     this.questRepository = questRepository;
    // }

    // @Override
    // public List<Quest> getAllQuests() {
    //     return questRepository.findAll();
    // }

    // @Override
    // public Quest getQuestById(long id) {
    //     return questRepository.findById((int) id).orElse(null);
    // }

    // @Override
    // public Quest createQuest(Quest quest) {
    //     return questRepository.save(quest);
    // }

    // @Override
    // public Quest updateQuest(long id, Quest quest) {
    //     Optional<Quest> existingQuest = questRepository.findById((int) id);
    //     if (existingQuest.isPresent()) {
    //         quest.setId(id);
    //         return questRepository.save(quest);
    //     } else {
    //         return null;
    //     }
    // }

    // @Override
    // public boolean deleteQuest(long id) {
    //     Optional<Quest> quest = questRepository.findById((int) id);
    //     if (quest.isPresent()) {
    //         questRepository.delete(quest.get());
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
}
