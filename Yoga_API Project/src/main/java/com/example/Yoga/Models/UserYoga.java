
package com.example.Yoga.Models;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="user_")
public class UserYoga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @OneToOne(mappedBy = "aUser")
    private Subscription subscriptions ;
    private String first_name ;
    private String last_name ;

    private String phone ;

    @Column(unique = true)
    private String email ;

    private String nationality ;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_of_birth;


    @OneToMany(mappedBy = "aUser")
    private List<Attendanceing> attendanceingList ;




    public UserYoga() {
    }

    public UserYoga(String first_name, String last_name, String phone,
                    String email, String nationality ) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.nationality = nationality;
        this.date_of_birth = date_of_birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", nationality='" + nationality + '\'' +
               // ", date_of_birth=" + date_of_birth +
                '}';
    }
}

