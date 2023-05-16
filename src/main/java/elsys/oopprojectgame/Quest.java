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
public class Quest {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private Location startLocation;
    private Location endLocation;
    private Item rewardItem;

    @OneToMany(mappedBy = "quest")
    @ToString.Exclude
    private List<Quest> quests;
}
