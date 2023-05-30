package elsys.oopprojectgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elsys.oopprojectgame.entity.NPC;

@Repository
public interface NPCRepository extends JpaRepository<NPC, Integer> {
    
}
