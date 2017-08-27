package com.cdk.at.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "accessories_details")
public class Accessories {


    @Id
    int vin;
    String rearBrakes;
    String frontBrakes;
    String door;
    String paintJob;
    String rearWheels;
    String frontTyres;
    String frontBumper;
    String frontCanards;
    String frontBumperLips;

    public Accessories() {
    }

    public Accessories(String rearBrakes, String frontBrakes, String door, String paintJob, String rearWheels, String frontTyres, String frontBumper, String frontCanards, String frontBumperLips) {
        this.rearBrakes = rearBrakes;
        this.frontBrakes = frontBrakes;
        this.door = door;
        this.paintJob = paintJob;
        this.rearWheels = rearWheels;
        this.frontTyres = frontTyres;
        this.frontBumper = frontBumper;
        this.frontCanards = frontCanards;
        this.frontBumperLips = frontBumperLips;
    }

    public Accessories(int vin, String rearBrakes, String frontBrakes, String door, String paintJob, String rearWheels, String frontTyres, String frontBumper, String frontCanards, String frontBumperLips) {
        this.vin = vin;
        this.rearBrakes = rearBrakes;
        this.frontBrakes = frontBrakes;
        this.door = door;
        this.paintJob = paintJob;
        this.rearWheels = rearWheels;
        this.frontTyres = frontTyres;
        this.frontBumper = frontBumper;
        this.frontCanards = frontCanards;
        this.frontBumperLips = frontBumperLips;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getRearBrakes() {
        return rearBrakes;
    }

    public void setRearBrakes(String rearBrakes) {
        this.rearBrakes = rearBrakes;
    }

    public String getFrontBrakes() {
        return frontBrakes;
    }

    public void setFrontBrakes(String frontBrakes) {
        this.frontBrakes = frontBrakes;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getPaintJob() {
        return paintJob;
    }

    public void setPaintJob(String paintJob) {
        this.paintJob = paintJob;
    }

    public String getRearWheels() {
        return rearWheels;
    }

    public void setRearWheels(String rearWheels) {
        this.rearWheels = rearWheels;
    }

    public String getFrontTyres() {
        return frontTyres;
    }

    public void setFrontTyres(String frontTyres) {
        this.frontTyres = frontTyres;
    }

    public String getFrontBumper() {
        return frontBumper;
    }

    public void setFrontBumper(String frontBumper) {
        this.frontBumper = frontBumper;
    }

    public String getFrontCanards() {
        return frontCanards;
    }

    public void setFrontCanards(String frontCanards) {
        this.frontCanards = frontCanards;
    }

    public String getFrontBumperLips() {
        return frontBumperLips;
    }

    public void setFrontBumperLips(String frontBumperLips) {
        this.frontBumperLips = frontBumperLips;
    }

    @Override
    public String toString() {
        return "Accessories{" +
                "vin=" + vin +
                ", rearBrakes='" + rearBrakes + '\'' +
                ", frontBrakes='" + frontBrakes + '\'' +
                ", door='" + door + '\'' +
                ", paintJob='" + paintJob + '\'' +
                ", rearWheels='" + rearWheels + '\'' +
                ", frontTyres='" + frontTyres + '\'' +
                ", frontBumper='" + frontBumper + '\'' +
                ", frontCanards='" + frontCanards + '\'' +
                ", frontBumperLips='" + frontBumperLips + '\'' +
                '}';
    }
}
