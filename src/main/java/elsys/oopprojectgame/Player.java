package elsys.oopprojectgame;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue
    private int id; 
    private String name;
    private Location currentLocation;
    private int health;
    private List<Item> items; 

    @OneToMany(mappedBy = "player")
    private List<Player> players; 
}
