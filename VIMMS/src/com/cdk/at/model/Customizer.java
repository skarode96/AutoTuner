package com.cdk.at.model;

import javax.persistence.*;

@Entity
@Table(name = "customizer_detail")
public class Customizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cId;
    String name;
    String category;
    int rating;
    double price;


    public Customizer() {
    }

    public Customizer(String name, String category, int rating, double price) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.price = price;
    }

    public Customizer(int cId, String name, String category, int rating, double price) {
        this.cId = cId;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Customizer{" +
                "cId=" + cId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}
