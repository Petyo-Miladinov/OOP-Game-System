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

import elsys.oopprojectgame.controllers.resources.NPCResource;
import elsys.oopprojectgame.service.NPCService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/npcs")
@RequiredArgsConstructor
public class NPCController {
    private final NPCService npcService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(npcService.getAllNPCs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(npcService.getNPCById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody NPCResource resource) {
        NPCResource saved = npcService.saveNPC(resource); 

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/bosses/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);  
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody NPCResource resource) {
        return ResponseEntity.ok(npcService.updateNPC(id, resource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        npcService.deleteNPC(id);
        return ResponseEntity.noContent().build();
    }
}
