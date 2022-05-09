package com.mfa.springmsgateway.service;

import com.mfa.springmsgateway.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUserName(String username);

    List<User> findAllUsers();
}
