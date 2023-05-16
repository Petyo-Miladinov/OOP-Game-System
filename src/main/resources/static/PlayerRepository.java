import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlayerRepository extends JavaRepository<Player, Integer> {
    
}
