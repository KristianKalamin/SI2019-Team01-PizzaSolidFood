package com.psf.psfrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "additions")
public class Additions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ADD")
    private int id;

    @Column(name = "ADD_NAME")
    private String additionName;

    @Column(name = "ADD_PRICE")
    private double additionPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdditionName() {
        return additionName;
    }

    public void setAdditionName(String additionName) {
        this.additionName = additionName;
    }

    public double getAdditionPrice() {
        return additionPrice;
    }

    public void setAdditionPrice(double additionPrice) {
        this.additionPrice = additionPrice;
    }
}
