package elsys.oopprojectgame.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import elsys.oopprojectgame.controllers.resources.QuestResource;
import elsys.oopprojectgame.service.QuestService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/quests") 
@RequiredArgsConstructor
public class QuestController {
    private final QuestService questService;

    @GetMapping
    public ResponseEntity<?> getAllQuests() {
        return ResponseEntity.ok(questService.getAllQuests());
    }

    @GetMapping("/quests/{id}")
    public ResponseEntity<?> getAllQuests(@PathVariable long id) {
        return ResponseEntity.ok(questService.getQuestById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody QuestResource resource) {
        QuestResource saved = questService.saveQuest(resource); 

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/bosses/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);  
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody QuestResource resource) {
        return ResponseEntity.ok(questService.updateQuest(id, resource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        questService.deleteQuest(id);
        return ResponseEntity.noContent().build();
    }
}
