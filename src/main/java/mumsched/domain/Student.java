package mumsched.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Student(String firstName, String lastName){
        super(firstName, lastName);
    }

    public Student() {
        super();
    }

    public String getFullName(){
        return this.getFirstName() + " "+ this.getLastName();
    }

    public Long getId(){
        return this.id;
    }


}
