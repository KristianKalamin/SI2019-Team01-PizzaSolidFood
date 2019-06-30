package com.psf.psfrest.service.email;

import com.google.common.collect.Lists;
import com.psf.psfrest.entity.OrderWithAddition;
import com.psf.psfrest.entity.OrderWithoutAddition;
import com.psf.psfrest.service.OrdersService;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.ImageType;
import it.ozimov.springboot.mail.model.InlinePicture;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultInlinePicture;
import it.ozimov.springboot.mail.service.EmailService;
import it.ozimov.springboot.mail.service.exception.CannotSendEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class Mail implements IMail {

    @Autowired
    public EmailService emailService;

    @Autowired
    private OrdersService ordersService;

    private void mailWithTemplate(String userName, String userEmail, String subject, String emailTemplate) throws IOException, CannotSendEmailException {
        final Email email = DefaultEmail.builder()
                .from(new InternetAddress("psf.no.reply@gmail.com", "Pizza Solid Food"))
                .to(Lists.newArrayList(new InternetAddress(userEmail, "Pizza Solid Food")))
                .subject(subject)
                .body("")
                .encoding("UTF-8").build();

        //Defining the model object for the given Freemarker template
        final Map<String, Object> modelObject = new HashMap<>();
        modelObject.put("userName", userName);

        Resource resource = new ClassPathResource("templates/psflogo.png");

        emailService.send(email, emailTemplate, modelObject, inlinePicture(resource.getFile()));
    }

    private void mailWithoutTemplate(String subject, String name, String customerMail, String msg) throws UnsupportedEncodingException {
        final Email email = DefaultEmail.builder()
                .from(new InternetAddress("psf.no.reply@gmail.com", subject))
                .to(Lists.newArrayList(new InternetAddress("psf.no.reply@gmail.com", subject)))
                .subject(subject)
                .body("Sender name: " + name + "\nSender email: " + customerMail + "\nMessage:\n" + msg)
                .encoding("UTF-8").build();

        emailService.send(email);
    }

    private void billMail(String userEmail, String subject, int orderNum, String address) throws IOException, CannotSendEmailException {
        final Email email = DefaultEmail.builder()
                .from(new InternetAddress("psf.no.reply@gmail.com", "Pizza Solid Food"))
                .to(Lists.newArrayList(new InternetAddress(userEmail, "Pizza Solid Food ")))
                .subject(subject + orderNum)
                .body("")
                .encoding("UTF-8").build();

        //Defining the model object for the given Freemarker template
        final Map<String, Object> modelObject = new HashMap<>();
        List<OrderWithAddition> ordersList = getOrdersList(orderNum);

        modelObject.put("userAddress", address);
        modelObject.put("products", ordersList);
        modelObject.put("userType", (ordersList.get(0).getUserType() == 1) ? true : false);
        modelObject.put("userName", ordersList.get(0).getUserName());
        modelObject.put("userLastname", ordersList.get(0).getUserLastName());
        modelObject.put("totalPrice", ordersList.get(0).getTotalPrice());
        modelObject.put("orderTime", ordersList.get(0).getDate());

        Resource resource = new ClassPathResource("templates/psflogo.png");

        emailService.send(email, "bill.ftl", modelObject, inlinePicture(resource.getFile()));
        ordersList.clear();
    }

    private List<OrderWithAddition> getOrdersList(int orderNum) {
        List<OrderWithoutAddition> orderWithoutAdditions = ordersService.getOrdersWithoutAdditionWith(orderNum);
        List<OrderWithAddition> orderWithAdditions = ordersService.getOrdersWithAdditionWith(orderNum);
        Iterator<OrderWithAddition> orderWithAdditionIterator = orderWithAdditions.listIterator();
        Iterator<OrderWithoutAddition> orderWithoutAdditionIterator = orderWithoutAdditions.listIterator();

        while (orderWithAdditionIterator.hasNext()) {
            while (orderWithoutAdditionIterator.hasNext()) {
                if (orderWithAdditionIterator.next().getIdOrder() == orderWithoutAdditionIterator.next().getIdOrder()) {
                    orderWithoutAdditionIterator.remove();
                }
            }
        }

        for (OrderWithoutAddition orderWithoutAddition : orderWithoutAdditions) {
            orderWithAdditions.add(new OrderWithAddition(
                    orderWithoutAddition.getIdOrder(),
                    orderWithoutAddition.getUserName(),
                    orderWithoutAddition.getUserLastName(),
                    orderWithoutAddition.getUserType(),
                    orderWithoutAddition.getTotalPrice(),
                    orderWithoutAddition.getDate(),
                    orderWithoutAddition.getPayment(),
                    orderWithoutAddition.getQuantity(),
                    orderWithoutAddition.getOrderNum(),
                    orderWithoutAddition.getProductName(),
                    orderWithoutAddition.getProductPrice(),
                    orderWithoutAddition.getDiscount(),
                    null,
                    0
            ));
        }

        return orderWithAdditions;
    }

    private InlinePicture inlinePicture(File file) {
        return DefaultInlinePicture.builder()
                .file(file)
                .imageType(ImageType.PNG)
                .templateName("psflogo.png").build();
    }

    @Override
    public void sendCongratulationsToNewPremiumUser(String userName, String email) throws IOException, CannotSendEmailException {
        mailWithTemplate(userName, email, "Premium Account", "premium.ftl");
    }

    @Override
    public void sendDowngrade(String userName, String email) throws IOException, CannotSendEmailException {
        mailWithTemplate(userName, email, "Premium Account Expired", "premium-expired.ftl");
    }

    @Override
    public void sendBillEmail(String email, int orderNum, String address) throws IOException, CannotSendEmailException {
        billMail(email, "Order", orderNum, address);
    }

    @Override
    public void customerMsg(String subject, String name, String customerMail, String msg) throws UnsupportedEncodingException {
        mailWithoutTemplate(subject, name, customerMail, msg);
    }

    @Override
    public void newsletter(String customerMail) throws IOException, CannotSendEmailException {
        mailWithTemplate("", customerMail, "Newsletter Subscription", "newsletter.ftl");
    }
}
