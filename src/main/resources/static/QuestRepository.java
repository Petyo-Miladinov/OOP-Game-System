import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuestRepository extends JavaRepository<Quest, Integer> {
    
}
