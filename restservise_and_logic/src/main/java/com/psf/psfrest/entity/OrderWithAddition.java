package com.psf.psfrest.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "order_with_addition")
public class OrderWithAddition {
    @Id
    @Column(name="id_order")
    private int idOrder;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_lastname")
    private String userLastName;

    @Column(name = "user_type")
    private int userType;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "date_time")
    private Date date;

    @Column(name = "payment")
    private String payment;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "order_num")
    private int orderNum;

    @Column(name = "prod_name")
    private String productName;

    @Column(name = "prod_price")
    private double productPrice;

    @Column(name = "discount_for_premium_users")
    private int discount;

    @Column(name = "add_name")
    private String addName;

    @Column(name = "add_price")
    private double addPrice;

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public OrderWithAddition() {
    }

    public OrderWithAddition(int idOrder, String userName, String userLastName, int userType, double totalPrice, Date date, String payment, int quantity, int orderNum, String productName, double productPrice, int discount, String addName, double addPrice) {
        this.idOrder = idOrder;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userType = userType;
        this.totalPrice = totalPrice;
        this.date = date;
        this.payment = payment;
        this.quantity = quantity;
        this.orderNum = orderNum;
        this.productName = productName;
        this.productPrice = productPrice;
        this.discount = discount;
        this.addName = addName;
        this.addPrice = addPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    public double getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(double addPrice) {
        this.addPrice = addPrice;
    }
}
