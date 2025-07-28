package backend.shai.model;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Group {

    private String name;

    @Id
    private int id;

    @ManyToOne
    private User owner;

    @ManyToMany
    private Set<User> members;

   private GroupType type;

    public enum GroupType {
        CHANNEL,
        GROUP
    }
}
