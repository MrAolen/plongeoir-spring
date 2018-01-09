package com.reeliant.plongeoir.configuration;

import com.reeliant.plongeoir.entity.MetaData;
import com.reeliant.plongeoir.entity.Role;
import com.reeliant.plongeoir.entity.User;
import com.reeliant.plongeoir.repository.MetaDataRepository;
import com.reeliant.plongeoir.repository.RoleRepository;
import com.reeliant.plongeoir.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Configuration
public class InitConfig{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MetaDataRepository metaDataRepository;

    @PostConstruct
    public void initData() {

        Role admin = new Role();
        admin.setName("ADMIN");
        roleRepository.save(admin);

        Role user = new Role();
        user.setName("USER");
        roleRepository.save(user);

        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName("USER"));

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");

        User userCurrent = new User();
        userCurrent.setEmail("gunthernic@eisti.eu");
        userCurrent.setHashedPassword(hashedPassword);
        userCurrent.setRoles(new HashSet<>(roles));
        userCurrent.setUsername("user");
        userCurrent.setAge(18L);
        userCurrent.setForname("Nicolas");
        userCurrent.setName("Gunther");
        userRepository.save(userCurrent);

        roles.add(roleRepository.findByName("ADMIN"));
        User userAdmin = new User();
        userAdmin.setEmail("gunthernic@eisti.eu");
        userAdmin.setHashedPassword(passwordEncoder.encode("admin"));
        userAdmin.setRoles(new HashSet<>(roles));
        userAdmin.setUsername("admin");
        userAdmin.setAge(18L);
        userAdmin.setForname("Nicolas");
        userAdmin.setName("Gunther");
        userRepository.save(userAdmin);

        MetaData hours = new MetaData();
        hours.setValue("");
        hours.setKey("hours");
        metaDataRepository.save(hours);

        MetaData rules = new MetaData();
        rules.setValue("");
        rules.setKey("rules");
        metaDataRepository.save(rules);

        MetaData home = new MetaData();
        home.setValue("");
        home.setKey("home");
        metaDataRepository.save(home);
    }
}