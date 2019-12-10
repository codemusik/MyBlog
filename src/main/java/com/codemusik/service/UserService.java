package com.codemusik.service;

import com.codemusik.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
