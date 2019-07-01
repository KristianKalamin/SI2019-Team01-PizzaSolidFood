package com.psf.psfrest;

import com.psf.psfrest.entity.User;
import com.psf.psfrest.service.UserService;
import com.psf.psfrest.service.email.Mail;
import it.ozimov.springboot.mail.service.exception.CannotSendEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static com.psf.psfrest.utils.Globals.premiumUsersCheckInterval;

@Component
public class PremiumUsersCheck implements Runnable {

    @Autowired
    private UserService userService;

    @Autowired
    private Mail mail;

    @Autowired
    private User currentUser;


    private List<User> list;
    private DateFormat dateFormat;
    private Date currentDate;
    private boolean isNewMonth = false;

    public PremiumUsersCheck() {
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.currentDate = new Date();
        this.list = new LinkedList<>();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("THREAD RUN");
            if (!list.isEmpty())
                list.clear();
            else {
                System.out.println("THREAD RUN");
                list.addAll(userService.getAllUsers());
                checkDate();
                if (isNewMonth) {
                    try {
                        resetUser();
                    } catch (CannotSendEmailException | IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        givePremiumAccount();
                    } catch (CannotSendEmailException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(premiumUsersCheckInterval * 60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void resetUser() throws IOException, CannotSendEmailException {
        for (User user : list) {
            currentUser = user;
            currentUser.setMonthlyOrders(0);
            currentUser.setPoints(0);
            if (currentUser.getUserType() == 1)
                mail.sendDowngrade(currentUser.getName(), currentUser.getEmail());

            currentUser.setUserType(0/*premium*/);
            userService.updateUserType(currentUser);
        }
    }

    private void checkDate() {
        String s = dateFormat.format(currentDate);
        int day = Integer.valueOf(s.substring(0, 2));
        int month = Integer.valueOf(s.substring(3, 5));
        isNewMonth = day == 1;
    }

    private void givePremiumAccount() throws IOException, CannotSendEmailException {
        for (User user : list) {
            currentUser = user;
            if (currentUser.getMonthlyOrders() >= 10 && currentUser.getPoints() >= 100 && currentUser.getUserType() == 0) {
                currentUser.setUserType(1/*premium*/);
                userService.updateUserType(currentUser);
                mail.sendCongratulationsToNewPremiumUser(currentUser.getName(), currentUser.getEmail());
            }
        }
    }
}
