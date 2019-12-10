package com.codemusik.service;

import com.codemusik.dao.UserRepository;
import com.codemusik.po.User;
import com.codemusik.util.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, AESUtil.aesEncode(password));
        return user;
    }
}
