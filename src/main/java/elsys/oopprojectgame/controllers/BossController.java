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

import elsys.oopprojectgame.controllers.resources.BossResource;
import elsys.oopprojectgame.service.BossService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/bosses")
@RequiredArgsConstructor
public class BossController {
    private final BossService bossService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(bossService.getAllBosses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(bossService.getBossById(id)); 
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BossResource resource) {
        BossResource saved = bossService.saveBoss(resource); 

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/bosses/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BossResource resource) {
        return ResponseEntity.ok(bossService.updateBoss(id, resource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        bossService.deleteBoss(id);
        return ResponseEntity.noContent().build();
    }
}
