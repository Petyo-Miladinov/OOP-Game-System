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
public class Location {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description; 

    @OneToMany(mappedBy = "location")
    @ToString.Exclude
    private List<Location> locations;
}
