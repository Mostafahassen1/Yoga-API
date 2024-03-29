package com.example.Yoga.Models;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="class_")
public class ClassYoga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(nullable = false)
    private String title ;   // the lesson in a Classes
    @Column(nullable = false)
    private String description ;  // addition information 1- level's Users  2- tools need
    @Column(nullable = false)
    private String start_time ;  // day and hour
    @Column(nullable = false)
    private String capacity ;  // Ex   10 person in class or 20 person

   @OneToMany(mappedBy = "aClass")
    private List<Attendanceing> attendanceings ;
    public ClassYoga() {
    }

    public ClassYoga(String title, String description, String start_time, String capacity) {
        this.title = title;
        this.description = description;
        this.start_time = start_time;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", start_time='" + start_time + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
