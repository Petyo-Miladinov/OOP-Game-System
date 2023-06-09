package elsys.oopprojectgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elsys.oopprojectgame.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    
}
