package com.psf.psfrest.service;

import com.psf.psfrest.repository.ProceduresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private ProceduresRepository proceduresRepository;

    private String mail;
    private String productName;
    private String payment;
    private int quantity;
    private int orderNum;
    private String additionName;

    @Override
    public void init(String mail, String productName, String payment, int quantity, int orderNum, String additionName) {
        this.mail = mail;
        this.productName = productName;
        this.payment = payment;
        this.quantity = quantity;
        this.orderNum = orderNum;
        this.additionName = additionName;
    }

    @Override
    public void addProductToOrder() {
        proceduresRepository.order(this.mail, this.productName, this.payment, this.quantity, this.orderNum);
    }

    @Override
    public void addAdditionsToOrder() {
        proceduresRepository.additionsForPremiumUsers(this.productName, this.orderNum, this.additionName);
    }

    @Override
    public void completeOrder() {
        proceduresRepository.completeOrder(this.orderNum, this.mail);
    }
}
