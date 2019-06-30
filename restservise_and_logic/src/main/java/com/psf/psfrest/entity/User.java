package com.psf.psfrest.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID_USER")
    private int id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_LASTNAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USER_TYPE")
    private int userType;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "POINTS")
    private int points;

    @Column(name = "MONTHLY_ORDERS")
    private int monthlyOrders;

    @Transient
    @JsonInclude()
    private String status;

    public User() {
    }

    public User(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMonthlyOrders() {
        return monthlyOrders;
    }

    public void setMonthlyOrders(int monthlyOrders) {
        this.monthlyOrders = monthlyOrders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                ", address='" + address + '\'' +
                ", points=" + points +
                ", monthlyOrders=" + monthlyOrders +
                '}';
    }
}
