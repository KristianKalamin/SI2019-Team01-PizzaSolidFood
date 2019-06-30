package com.psf.psfrest.repository;

import com.psf.psfrest.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByEmailEquals(String email);
}
