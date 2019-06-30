package com.psf.psfrest.service;

import com.psf.psfrest.entity.User;

import java.util.List;

public interface IUserService {
    User findUserByEmail(String email);
    void saveNewUser(User user);
    void updateUserType(User user);
    List<User> getAllUsers();
}
