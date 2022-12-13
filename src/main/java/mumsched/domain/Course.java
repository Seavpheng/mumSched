package mumsched.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String courseName;
//    @Column
//    private boolean isActive;

    public Course(){  }

    private Course(String courseName){
        this.courseName = courseName;
    }

    public static Course createCourse(String courseName){
        return new Course(courseName);
    }


    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

//    public boolean isActive() {
//        return isActive;
//    }
//
//    public void setActive(boolean active) {
//        isActive = active;
//    }

    public String toString(){
        return "Course {" +
                "id : " + this.getId() +","+
                "courseName : " + this.getCourseName() +"}" ;

    }
}
