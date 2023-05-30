package elsys.oopprojectgame.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String name;

    @ManyToOne
    @JoinColumn(name = "currentLocation_id")
    private Location currentLocation;
    private int health;
    
    private List<Item> items; 

    @OneToMany(mappedBy = "player")
    private List<Player> players; 
}
