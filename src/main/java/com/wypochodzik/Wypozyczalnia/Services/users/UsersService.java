package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.DTO.UserCreationDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UserEntity;

public interface UsersService {

    UserEntity getUser(Long userId);
    UserEntity createUser(UserCreationDTO userCreationDTO);
    UserEntity updateUser(Long userId);
    UserEntity deleteUser(Long userId);
}
