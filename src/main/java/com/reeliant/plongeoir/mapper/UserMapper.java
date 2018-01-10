package com.reeliant.plongeoir.mapper;

import com.reeliant.plongeoir.dto.UserDTO;
import com.reeliant.plongeoir.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper{
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO user);
}
