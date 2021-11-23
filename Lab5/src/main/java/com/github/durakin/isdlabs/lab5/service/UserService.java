package com.github.durakin.isdlabs.lab5.service;

import com.github.durakin.isdlabs.lab5.entity.User;

public interface UserService {
    User FindById(int id);
    void SaveUser(User user);
    }
