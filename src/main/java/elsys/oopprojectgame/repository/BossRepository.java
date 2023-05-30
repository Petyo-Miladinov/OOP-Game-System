package elsys.oopprojectgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elsys.oopprojectgame.entity.Boss;

@Repository
public interface BossRepository extends JpaRepository<Boss, Integer> {
    
}
