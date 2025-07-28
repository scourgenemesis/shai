package backend.shai.model;


import jakarta.persistence.*;

import java.security.Permission;
import java.util.Set;

@Entity
public class Group {

    private String name;

    @Id
    private String id;

    @ManyToOne
    private User owner;

    @ManyToMany
    private Set<User> members;

   private GroupType type;

    public enum GroupType {
        CHANNEL,
        GROUP
    }

    public class GroupRole {
        @Id
        private String id;

        private String name;

        @ManyToOne
        private Group group;

        @ElementCollection
        private Set<Permission> permissions;
    }

    @Entity
    public class GroupMember {
       @ManyToOne
       private Group group;

       @ManyToOne
        private User user;

       @ManyToMany
        private Set<GroupRole> roles;
    }
}
