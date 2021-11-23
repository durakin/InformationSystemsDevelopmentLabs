package com.github.durakin.isdlabs.lab5.service.impl;

import com.github.durakin.isdlabs.lab5.entity.User;
import com.github.durakin.isdlabs.lab5.repository.RoleRepository;
import com.github.durakin.isdlabs.lab5.repository.UserRepository;
import com.github.durakin.isdlabs.lab5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void SaveUser(User user) {
        user.getRoles().add(roleRepository.findByRole("USER"));
        userRepository.save(user);
    }

    @Override
    public User FindById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
