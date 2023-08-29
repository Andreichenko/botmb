package org.caller.botmb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Rocket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double maxPower;
    private double accuracy;
    private double cost;
    private double power;

    public Rocket() {
    }

    public Rocket(Long id, String name, double maxPower, double accuracy, double cost) {
        this.id = id;
        this.name = name;
        this.maxPower = maxPower;
        this.accuracy = accuracy;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(double maxPower) {
        this.maxPower = maxPower;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rocket rocket = (Rocket) o;
        return Double.compare(rocket.maxPower, maxPower) == 0 && Double.compare(rocket.accuracy, accuracy) == 0 && Double.compare(rocket.cost, cost) == 0 && Objects.equals(id, rocket.id) && Objects.equals(name, rocket.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maxPower, accuracy, cost);
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxPower=" + maxPower +
                ", accuracy=" + accuracy +
                ", cost=" + cost +
                '}';
    }
}
