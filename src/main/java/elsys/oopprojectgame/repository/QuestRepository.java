package elsys.oopprojectgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elsys.oopprojectgame.entity.Quest;

@Repository
public interface QuestRepository extends JpaRepository<Quest, Integer> {
    
}
