package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;

public interface UsersService {

    UsersEntity getUser(Long userId);
    UsersEntity createUser(UsersCreationDTO usersCreationDTO);
    UsersEntity updateUser(Long userId);
    UsersEntity deleteUser(Long userId);
}
