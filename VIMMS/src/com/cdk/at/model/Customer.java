package com.cdk.at.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name="customer_detail")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int uid;
    String name;
    String emailId;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "uid")
    Set<Car> cars = null;

    public Customer() {
    }

    public Customer(int uid, String name, String emailId, Set<Car> cars) {
        this.uid = uid;
        this.name = name;
        this.emailId = emailId;
        this.cars = cars;
    }

    public Customer(String name, String emailId, Set<Car> cars) {
        this.name = name;
        this.emailId = emailId;
        this.cars = cars;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", cars=" + cars +
                '}';
    }
}
