package com.reeliant.plongeoir.service.impl;

import com.reeliant.plongeoir.entity.User;
import com.reeliant.plongeoir.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;

public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getHashedPassword(), new HashSet<>());
    }
}
