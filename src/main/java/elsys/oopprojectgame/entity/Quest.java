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
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne 
    @JoinColumn(name = "startLocation_id")
    private Location startLocation;

    @ManyToOne
    @JoinColumn(name = "endLocation_id")
    private Location endLocation;

    @OneToOne 
    @JoinColumn(name = "rewardItem_id")
    private Item rewardItem;

    @OneToMany(mappedBy = "quest")
    @ToString.Exclude
    private List<Quest> quests;
}
