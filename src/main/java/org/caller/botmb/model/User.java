package org.caller.botmb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int points;
    private Date lastAttackDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getLastAttackDate() {
        return lastAttackDate;
    }

    public void setLastAttackDate(Date lastAttackDate) {
        this.lastAttackDate = lastAttackDate;
    }

    public User(Long id, String username, int points, Date lastAttackDate) {
        this.id = id;
        this.username = username;
        this.points = points;
        this.lastAttackDate = lastAttackDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return points == user.points && Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(lastAttackDate, user.lastAttackDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, points, lastAttackDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", points=" + points +
                ", lastAttackDate=" + lastAttackDate +
                '}';
    }
}
