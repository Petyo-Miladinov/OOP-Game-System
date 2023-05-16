package elsys.oopprojectgame;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class PlayerQuest {
    @Id
    @GeneratedValue
    private Player player;
    private Quest quest;
    private String status;

    @OneToMany(mappedBy = "playerQuest")
    @ToString.Exclude
    private List<PlayerQuest> playerQuests;
}
