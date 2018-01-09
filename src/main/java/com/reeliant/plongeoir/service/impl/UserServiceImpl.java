package com.reeliant.plongeoir.service.impl;

import com.reeliant.plongeoir.dto.UserCreationDTO;
import com.reeliant.plongeoir.dto.UserDTO;
import com.reeliant.plongeoir.entity.Role;
import com.reeliant.plongeoir.entity.User;
import com.reeliant.plongeoir.mapper.UserMapper;
import com.reeliant.plongeoir.repository.RoleRepository;
import com.reeliant.plongeoir.repository.UserRepository;
import com.reeliant.plongeoir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMapper userMapper;


    @Override
    public void createUser(UserCreationDTO userCreationDTO) {
        Role role = roleRepository.findByName("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(role);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(userCreationDTO.getPassword());

        User userCurrent = new User();
        userCurrent.setEmail(userCreationDTO.getEmail());
        userCurrent.setHashedPassword(hashedPassword);
        userCurrent.setRoles(new HashSet<>(roles));
        userCurrent.setUsername(userCreationDTO.getUsername());
        userCurrent.setAge(Long.parseLong(userCreationDTO.getAge().toString()));
        userCurrent.setForname(userCreationDTO.getForname());
        userCurrent.setName(userCreationDTO.getName());
        userRepository.save(userCurrent);
    }

    public UserDTO getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        return userMapper.userToUserDTO(user);
    }

    @Override
    public void updateUser(UserCreationDTO userCreationDTO) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());

        user.setUsername(userCreationDTO.getUsername());
        user.setName(userCreationDTO.getName());
        user.setForname(userCreationDTO.getForname());
        user.setEmail(userCreationDTO.getEmail());

        if (!userCreationDTO.getPassword().equals("") && userCreationDTO.getPassword().equals(userCreationDTO.getConfirmPassword())) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(userCreationDTO.getPassword());
            user.setHashedPassword(hashedPassword);
        }
        userRepository.save(user);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getHashedPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
