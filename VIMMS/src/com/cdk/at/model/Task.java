package com.cdk.at.model;

import javax.persistence.*;

@Entity
@Table( name="task_detail")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tId;
    String taskName;
    int vin;
    int cId;
    double price;

    public Task() {
    }

    public Task(String taskName, int vin, int cId,double price) {
        this.taskName = taskName;
        this.vin = vin;
        this.cId = cId;
        this.price = price;
    }

    public Task(int tId, String taskName, int vin, int cId,double price) {
        this.tId = tId;
        this.taskName = taskName;
        this.vin = vin;
        this.cId = cId;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }
}
