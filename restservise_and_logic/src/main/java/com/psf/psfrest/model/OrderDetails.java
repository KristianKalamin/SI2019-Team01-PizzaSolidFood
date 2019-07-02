package com.psf.psfrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue
    @JsonIgnore()
    private int id;

    private String mail;
    private int userType;
    private String productName;
    private String payment;
    private int quantity;
    private int orderNum;
    private String additionName;

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getAdditionName() {
        return additionName;
    }

    public void setAdditionName(String additionName) {
        this.additionName = additionName;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", userType=" + userType +
                ", productName='" + productName + '\'' +
                ", payment='" + payment + '\'' +
                ", quantity=" + quantity +
                ", orderNum=" + orderNum +
                ", additionName='" + additionName + '\'' +
                '}';
    }
}
