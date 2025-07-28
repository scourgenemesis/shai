package backend.shai.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Group {

    private String name;

    @Id
    private int id;

    @ManyToOne
    private User 
}
