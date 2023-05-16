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
public class NPC {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private Location location;
    private Quest quest;

    @OneToMany(mappedBy = "npc")
    @ToString.Exclude
    private List<NPC> npcs;
}
