package com.psf.psfrest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.psf.psfrest.entity.User;
import com.psf.psfrest.service.IUserService;
import com.psf.psfrest.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private Utils utils;
    @Autowired
    private IUserService userService;
    @Autowired
    private User googleUser;
    @Autowired
    private User psfUser;

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser(UsernamePasswordAuthenticationToken p) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(p.getPrincipal());
        googleUser = utils.getUserCredentials(jsonString);

        psfUser = userService.findUserByEmail(googleUser.getEmail());
        if (psfUser == null) {
            //System.out.println(googleUser);
            userService.saveNewUser(googleUser);
            googleUser.setStatus("loggedin");
            return ResponseEntity.ok(googleUser);
        }
        else {
            //System.out.println(psfUser);
            psfUser.setStatus("loggedin");
            return ResponseEntity.ok(psfUser);
        }
    }
}
