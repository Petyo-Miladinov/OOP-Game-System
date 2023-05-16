import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BossRepository extends JavaRepository<Boss, Integer> {
    
}
