package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.Entities.UserEntity;

public interface UsersService {

    UserEntity getUser(Long userId);
    UserEntity createUser(UserEntity userEntity);
    UserEntity updateUser(Long userId);
    UserEntity deleteUser(Long userId);
}
