package org.caller.botmb.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int populationDensity;
    private double defenseFactor;

    public City(Long id, String name, int populationDensity, double defenseFactor) {
        this.id = id;
        this.name = name;
        this.populationDensity = populationDensity;
        this.defenseFactor = defenseFactor;
    }

    public City() {
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

    public int getPopulationDensity() {
        return populationDensity;
    }

    public void setPopulationDensity(int populationDensity) {
        this.populationDensity = populationDensity;
    }

    public double getDefenseFactor() {
        return defenseFactor;
    }

    public void setDefenseFactor(double defenseFactor) {
        this.defenseFactor = defenseFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return populationDensity == city.populationDensity && Double.compare(city.defenseFactor, defenseFactor) == 0 && Objects.equals(id, city.id) && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, populationDensity, defenseFactor);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", populationDensity=" + populationDensity +
                ", defenseFactor=" + defenseFactor +
                '}';
    }
}
