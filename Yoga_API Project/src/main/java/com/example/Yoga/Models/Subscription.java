
package com.example.Yoga.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="Subscription")
public class Subscription {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @OneToOne
    @JoinColumn(name = "User_id" , nullable = false)
    @JsonIgnoreProperties({"first_name","last_name","phone" , "email" , "nationality" , "date_of_birth"})
    private UserYoga  aUser ;



     @ManyToOne
     @JoinColumn(name ="id_Package" )
      @JsonIgnoreProperties({"name" , "price"})
     private PackageYoga aPackage ;


    @OneToMany(mappedBy = "subscripe")
    private List<PaymentYoga> paymentList;


    @Column(nullable = false)
    private int number_Of_Session ;

    @Column(nullable = false)
    private LocalDateTime Subscription_data ; // this will add automatically

    public Subscription() {
    }



    public Subscription(UserYoga user, PackageYoga aPackage , int number_Of_Session) {
        this.aUser = user;
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

   public UserYoga getUser() {
        return aUser;
    }



    public void setUser(UserYoga user) {
        this.aUser = user;
    }


    public PackageYoga getaPackage() {
        return aPackage;
    }

    public void setaPackage(PackageYoga aPackage) {
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
                ", user =" + aUser +
                ", aPackage=" + aPackage +
                ", number_Of_Session=" + number_Of_Session +
                ", Subscription_data=" + Subscription_data +
                '}';
    }
}




