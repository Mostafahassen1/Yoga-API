
package com.example.Yoga.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Package")
public class Packages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;
    @Column(nullable = false)
    private  String name ;
    @Column(nullable = false)
    private  int price ;



    @OneToMany(mappedBy = "aPackage")
   private List<Subscriptions> subscriptionsList ;


    public Packages() {
    }

    public Packages(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Packages{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

// there is three package
/*
Package A : yoga
Package B : yoga , Pilates
package C : yoga , Pilates , Taichi
 */