import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlayerQuestRepository extends JavaRepository<PlayerQuest, Integer> {
    
}
