package mumsched.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName){
        super(firstName, lastName);
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String toString(){
        return "Student : {" + this.id + "," +
                this.getFullName() +" }";


    }


}
