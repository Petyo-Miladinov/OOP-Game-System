package elsys.oopprojectgame.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Boss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int health;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToOne 
    @JoinColumn(name = "lootItem_id")
    private Item lootItem;

    @OneToMany(mappedBy = "boss") 
    @ToString.Exclude
    private List<Quest> quests;
}
