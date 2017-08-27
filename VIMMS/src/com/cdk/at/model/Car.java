package com.cdk.at.model;

import javax.persistence.*;

@Entity
@Table( name="car_detail")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int vin;

    String model;

    String make;

    double price;





    public Car() {
    }

    public Car(String model, String make, double price) {
        this.model = model;
        this.make = make;
        this.price = price;
    }

    public Car(int vin, String model, String make, double price) {
        this.vin = vin;
        this.model = model;
        this.make = make;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String name) {
        this.model = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin=" + vin +
                ", name='" + model + '\'' +
                ", make='" + make + '\'' +
                ", price=" + price +
                '}';
    }
}
