package com.psf.psfrest.utils;

import com.auth0.jwt.JWT;
import com.psf.psfrest.model.JwtUser;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Base64;

@Component
public class JwtTokenValidator {

    /**
     * Tries to parse specified String as a JWT token. If successful, returns User object with username, id and role prefilled (extracted from token).
     * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
     *
     * @param token the JWT token to parse
     * @return the User object extracted from specified token or null if a token is invalid.
     */
    @Deprecated
    public JwtUser parseToken(String token) {
        JwtUser user = null;
        try {
            byte[] base = Base64.getDecoder().decode(JWT.decode(token).getPayload().getBytes());
            JSONObject jsonObject = new JSONObject(IOUtils.toString(base));
            user = new JwtUser();
            user.setEmail(jsonObject.getString("email"));
            user.setName(jsonObject.getString("given_name"));
            user.setLastname(jsonObject.getString("family_name"));
            user.setRole("user");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }


}