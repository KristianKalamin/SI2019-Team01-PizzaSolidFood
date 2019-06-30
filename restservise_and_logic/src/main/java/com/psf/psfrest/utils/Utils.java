package com.psf.psfrest.utils;

import com.jayway.jsonpath.JsonPath;
import com.psf.psfrest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Utils {

    private final User user;

    @Autowired
    public Utils(User user) {
        this.user = user;
    }

    public User getUserCredentials(String jsonString) {
        user.setName(JsonPath.read(jsonString, "$.name"));
        user.setLastName(JsonPath.read(jsonString, "$.lastname"));
        user.setEmail(JsonPath.read(jsonString, "$.email"));

        return user;
    }
}
