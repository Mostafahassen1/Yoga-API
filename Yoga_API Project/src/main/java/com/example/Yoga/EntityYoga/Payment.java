

package com.example.Yoga.EntityYoga;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @ManyToOne
    @JoinColumn(name = "id_subscription" , nullable = false )
    @JsonIgnoreProperties({"user" , "subscription_data" , "number_Of_Session" , "aPackage" } )
    private Subscriptions subscripe ;

    @Column(nullable = false)
    private  int amount ;


    @Column(nullable = false)
    private LocalDateTime payment_date ;

    @Column(nullable = false)
    private String paymentMethod ;

    public Payment() {
    }

    public Payment(Subscriptions subscripe, int amount, LocalDateTime payment_date, String paymentMethod) {
        this.subscripe = subscripe;
        this.amount = amount;
        this.payment_date = LocalDateTime.now();
        this.paymentMethod = paymentMethod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subscriptions getSubscripe() {
        return subscripe;
    }

    public void setSubscripe(Subscriptions subscripe) {
        this.subscripe = subscripe;
    }

    public int getPayment() {
        return amount;
    }

    public void setPayment(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDateTime payment_date) {
        this.payment_date = payment_date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", subscripe=" + subscripe +
                ", payment=" + amount +
                ", payment_date=" + payment_date +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}

