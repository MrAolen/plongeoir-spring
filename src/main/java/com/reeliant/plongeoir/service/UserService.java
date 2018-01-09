package com.reeliant.plongeoir.service;

import com.reeliant.plongeoir.dto.UserCreationDTO;
import com.reeliant.plongeoir.dto.UserDTO;
import com.reeliant.plongeoir.entity.User;

public interface UserService{
    void createUser(UserCreationDTO userCreationDTO);

    UserDTO getCurrentUser();

    void updateUser(UserCreationDTO userCreationDTO);
}
