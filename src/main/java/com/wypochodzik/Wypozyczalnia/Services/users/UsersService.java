package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.UsersUpdateDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;

public interface UsersService {

    UsersEntity getUser(Long userId);
    UsersEntity createUser(UsersCreationDTO userCreationDTO);
    UsersEntity updateUser(Long userId, UsersUpdateDTO userUpdateDTO);
    void deleteUser(Long userId);
}
