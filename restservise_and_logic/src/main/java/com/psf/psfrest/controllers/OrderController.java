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
    }

    @GetMapping("/auth/order")
    public @ResponseBody void order(@RequestBody List<OrderDetails> orderDetails) throws IOException, CannotSendEmailException {

        for (OrderDetails orderDetail : orderDetails) {
            orderService.init(
                    orderDetail.getMail(),
                    orderDetail.getProductName(),
                    orderDetail.getPayment(),
                    orderDetail.getQuantity(),
                    orderDetail.getOrderNum(),
                    orderDetail.getAdditionName()
            );

           orderService.addProductToOrder();
           if (orderDetail.getUserType() == 1 && !orderDetail.getAdditionName().equals(""))
               orderService.addAdditionsToOrder();

        }
        orderService.completeOrder();
        mail.sendBillEmail(orderDetails.get(0).getMail(), orderDetails.get(0).getOrderNum(), this.address);
    }
}
