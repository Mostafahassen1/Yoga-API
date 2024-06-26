
package com.example.Yoga.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="attend")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Attendanceing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="Student_id")
    @JsonIgnoreProperties({"first_name", "last_name", "phone", "email", "nationality", "date_of_birth"})
    private UserYoga aUser ;

   @ManyToOne
   @JoinColumn(name="class_id")
   @JsonIgnoreProperties({"title", "description", "start_time", "capacity"})
   private ClassYoga aClass ;


    private LocalDateTime attendance_date ;


    public Attendanceing() {
    }

    public Attendanceing(ClassYoga aClass , UserYoga aUser ) {
        this.aUser = aUser;
        this.aClass = aClass ;
        this.attendance_date = LocalDateTime.now();
    }

    public UserYoga getaUser() {
        return aUser;
    }


    public void setaUser(UserYoga aUser) {
        this.aUser = aUser;
    }

    public ClassYoga getaClass() {

        return  aClass;
    }



    public void setaClass(ClassYoga aClass) {

        this.aClass = aClass ;
    }

    public LocalDateTime getAttendance_date() {

        return attendance_date;
    }

    public void setAttendance_date(LocalDateTime attendance_date) {

        this.attendance_date = attendance_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "aUser=" + aUser +
                ", aClass=" + aClass +
                ", attendance_date=" + attendance_date +
                '}';
    }
}




