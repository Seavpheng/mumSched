package mumsched.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty")
public class Faculty extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Faculty(String firstName, String lastName) {

        super(firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
