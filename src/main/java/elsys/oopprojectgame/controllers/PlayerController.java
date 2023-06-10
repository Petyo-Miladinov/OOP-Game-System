package elsys.oopprojectgame.controllers;

import org.springframework.http.HttpStatus;
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

import elsys.oopprojectgame.controllers.resources.PLayerResource;
import elsys.oopprojectgame.service.PlayerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService; 

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(playerService.getPlayerById(id));

        // Player player = playerService.getPlayerById(id);
        // if (player != null) {
        //     return new ResponseEntity<>(player, HttpStatus.OK);
        // } else {
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
    }
    
    @PostMapping
    public ResponseEntity<?> createPlayer(@RequestBody PLayerResource resource) {
        PLayerResource saved = playerService.savePlayer(resource); 

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/bosses/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);  
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable long id, @RequestBody PLayerResource resource) {
        return ResponseEntity.ok(playerService.updatePlayer(id, resource));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable long id) {
        boolean deleted = playerService.deletePlayer(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
