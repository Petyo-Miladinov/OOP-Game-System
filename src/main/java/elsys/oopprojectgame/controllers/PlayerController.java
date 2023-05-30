package elsys.oopprojectgame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import elsys.oopprojectgame.entity.Player;
import elsys.oopprojectgame.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService; 

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable long id) {
        Player player = playerService.getPlayerById(id);
        if (player != null) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player savedPlayer = playerService.createPlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable long id, @RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(id, player);
        if (updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable long id) {
        boolean deleted = playerService.deletePlayer(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}