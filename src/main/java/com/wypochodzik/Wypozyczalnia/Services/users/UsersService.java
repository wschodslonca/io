package com.wypochodzik.Wypozyczalnia.Services.users;


import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.UsersUpdateDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;
import com.wypochodzik.Wypozyczalnia.DTO.UserChangePasswordDTO;

import java.util.List;

public interface UsersService {

    UsersEntity getUser(Long userId);
    List<UsersEntity> getAllUsers();
    UsersEntity createUser(UsersCreationDTO userCreationDTO);
    UsersEntity updateUser(Long userId, UsersUpdateDTO userUpdateDTO);
    void deleteUser(Long userId);
    UsersEntity changePassword(Long userId, UserChangePasswordDTO userPasswordChangeDto);
}
