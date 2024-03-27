
package com.example.Yoga.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="Subscriptions")
public class Subscriptions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @OneToOne
    @JoinColumn(name = "User_id" , nullable = false)
    @JsonIgnoreProperties({"first_name","last_name","phone" , "email" , "nationality" , "date_of_birth"})
    private Users user ;



     @ManyToOne
     @JoinColumn(name ="id_Package" )
      @JsonIgnoreProperties({"name" , "price"})
     private Packages aPackage ;


    @OneToMany(mappedBy = "subscripe")
    private List<Payment> paymentList;


    @Column(nullable = false)
    private int number_Of_Session ;

    @Column(nullable = false)
    private LocalDateTime Subscription_data ; // this will add automatically

    public Subscriptions() {
    }



    public Subscriptions(Users user, Packages aPackage ,  int number_Of_Session) {
        this.user = user;
       this.aPackage = aPackage;
        Subscription_data = LocalDateTime.now();
        this.number_Of_Session = number_Of_Session;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   public Users getUser() {
        return user;
    }



    public void setUser(Users user) {
        this.user = user;
    }


    public Packages getaPackage() {
        return aPackage;
    }

    public void setaPackage(Packages aPackage) {
        this.aPackage = aPackage;
    }

    public int getNumber_Of_Session() {
        return number_Of_Session;
    }

    public void setNumber_Of_Session(int number_Of_Session) {
        this.number_Of_Session = number_Of_Session;
    }

    public LocalDateTime getSubscription_data() {

        return Subscription_data;
    }

    public void setSubscription_data(LocalDateTime subscription_data) {

        Subscription_data = subscription_data;
    }

    @Override
    public String toString() {
        return "Subscriptions{" +
                "id=" + id +
                ", user=" + user +
                ", aPackage=" + aPackage +
                ", number_Of_Session=" + number_Of_Session +
                ", Subscription_data=" + Subscription_data +
                '}';
    }
}




