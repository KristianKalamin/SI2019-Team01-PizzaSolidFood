package com.psf.psfrest.service;

public interface IOrderService {
    void addProductToOrder();
    void addAdditionsToOrder();
    void completeOrder();
    void init(String mail, String productName, String payment, int quantity, int orderNum, String additionName);
}
