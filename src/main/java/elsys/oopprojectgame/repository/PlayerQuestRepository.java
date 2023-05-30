package elsys.oopprojectgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elsys.oopprojectgame.entity.PlayerQuest;

@Repository
public interface PlayerQuestRepository extends JpaRepository<PlayerQuest, Integer> {
    
}
