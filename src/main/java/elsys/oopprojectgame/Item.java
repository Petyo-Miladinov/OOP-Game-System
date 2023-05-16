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
public class Item {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private Location location; 
    private Player player;

    @OneToMany(mappedBy = "item")
    @ToString.Exclude
    private List<Item> items;
}
