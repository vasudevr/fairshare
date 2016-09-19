package com.vasu.fairshare.account.service;

import com.vasu.fairshare.account.model.User;


public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
