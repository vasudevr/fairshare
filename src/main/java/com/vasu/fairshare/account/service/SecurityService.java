package com.vasu.fairshare.account.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
