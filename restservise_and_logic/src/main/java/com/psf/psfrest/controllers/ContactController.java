package com.psf.psfrest.controllers;

import com.psf.psfrest.service.email.IMail;
import it.ozimov.springboot.mail.service.exception.CannotSendEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RestController
public class ContactController {

    @Autowired
    private IMail mail;

    @GetMapping("/public/contact")
    public @ResponseBody RedirectView contact(@RequestParam(name = "subject") String subject,
                         @RequestParam(name = "name") String name,
                         @RequestParam(name = "customerMail") String customerMail,
                         @RequestParam(name = "msg") String msg) throws UnsupportedEncodingException {
        mail.customerMsg(subject, name, customerMail, msg);
        return new RedirectView("http://localhost:5501");
    }
}
