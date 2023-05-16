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
public class Boss {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int health;
    private Location location;
    private Item lootItem;

    @OneToMany(mappedBy = "boss") 
    @ToString.Exclude
    private List<Quest> quests;
}
