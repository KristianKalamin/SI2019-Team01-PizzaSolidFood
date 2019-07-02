package com.psf.psfrest.controllers;

import com.psf.psfrest.model.OrderDetails;
import com.psf.psfrest.service.IOrderService;
import com.psf.psfrest.service.email.Mail;
import it.ozimov.springboot.mail.service.exception.CannotSendEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin
public class OrderController {

    @Autowired
    private Mail mail;

    @Autowired
    private IOrderService orderService;

    private String address;

    @GetMapping("/public/address")
    public @ResponseBody void setAddress(@RequestParam(name = "userAddress") String userAddress) {
        this.address = userAddress;
        System.out.println(this.address);
    }

    @PostMapping("/auth/order")
    public @ResponseBody void order(@RequestBody OrderDetails orderDetails) throws IOException, CannotSendEmailException {

        System.out.println(orderDetails.toString());
        orderService.init(
                orderDetails.getMail(),
                orderDetails.getProductName(),
                orderDetails.getPayment(),
                orderDetails.getQuantity(),
                orderDetails.getOrderNum(),
                orderDetails.getAdditionName()
        );

        orderService.addProductToOrder();
        if (orderDetails.getUserType() == 1 && !orderDetails.getAdditionName().equals("null"))
            orderService.addAdditionsToOrder();


        orderService.completeOrder();
        mail.sendBillEmail(orderDetails.getMail(), orderDetails.getOrderNum(), this.address);
    }
}
