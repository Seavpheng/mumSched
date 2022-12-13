package mumsched.domain;

import jakarta.persistence.*;

@Table(name ="entry")
@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String month;
    private Integer year;

//    public Entry(String month, Integer year) {
//        this.month = month;
//        this.year = year;
//    }

    public Entry() {

    }

    public String getMonth(){
        return this.month;
    }

    public void setMonth(String month){
        this.month = month;
    }

    public Integer getYear(){
        return this.year;
    }

    public void setYear(Integer year){
        this.year = year;
    }
}
