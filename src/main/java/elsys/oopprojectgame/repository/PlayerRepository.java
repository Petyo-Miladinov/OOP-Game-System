package elsys.oopprojectgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elsys.oopprojectgame.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    
}
