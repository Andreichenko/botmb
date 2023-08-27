package org.caller.botmb.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Attack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private City city;

    private double power;
    private double damage;
    private Date attackDate;

    public Attack() {
    }

    public Attack(Long id, User user, City city, double power, double damage, Date attackDate) {
        this.id = id;
        this.user = user;
        this.city = city;
        this.power = power;
        this.damage = damage;
        this.attackDate = attackDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public Date getAttackDate() {
        return attackDate;
    }

    public void setAttackDate(Date attackDate) {
        this.attackDate = attackDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attack attack = (Attack) o;
        return Double.compare(attack.power, power) == 0 && Double.compare(attack.damage, damage) == 0 && Objects.equals(id, attack.id) && Objects.equals(user, attack.user) && Objects.equals(city, attack.city) && Objects.equals(attackDate, attack.attackDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, city, power, damage, attackDate);
    }

    @Override
    public String toString() {
        return "Attack{" +
                "id=" + id +
                ", user=" + user +
                ", city=" + city +
                ", power=" + power +
                ", damage=" + damage +
                ", attackDate=" + attackDate +
                '}';
    }
}
