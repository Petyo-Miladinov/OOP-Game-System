package elsys.oopprojectgame.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import elsys.oopprojectgame.controllers.resources.PlayerQuestResource;
import elsys.oopprojectgame.service.PlayerQuestService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/player-quests")
@RequiredArgsConstructor
public class PlayerQuestController {
    private final PlayerQuestService playerQuestService;

    @GetMapping
    public ResponseEntity<?> getAllPlayerQuests() {
        return ResponseEntity.ok(playerQuestService.getAllPlayerQuests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerQuestById(@PathVariable long id) {
        return ResponseEntity.ok(playerQuestService.getPlayerQuestById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PlayerQuestResource resource) {
        PlayerQuestResource saved = playerQuestService.savePlayerQuest(resource); 

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/bosses/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);  
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<?> update(@PathVariable long id, @RequestBody PlayerQuestResource resource) {
    //     return ResponseEntity.ok(playerQuestService.updatePlayerQuest(id, resource));
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        playerQuestService.deletePlayerQuest(id);
        return ResponseEntity.noContent().build();
    }
}
