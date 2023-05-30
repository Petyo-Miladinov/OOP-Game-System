package elsys.oopprojectgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elsys.oopprojectgame.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    
}
