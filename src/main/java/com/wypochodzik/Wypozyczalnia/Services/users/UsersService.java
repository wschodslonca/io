package com.wypochodzik.Wypozyczalnia.Services.users;

<<<<<<< HEAD
import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;

public interface UsersService {

    UsersEntity getUser(Long userId);
    UsersEntity createUser(UsersCreationDTO usersCreationDTO);
    UsersEntity updateUser(Long userId);
    UsersEntity deleteUser(Long userId);
=======
import com.wypochodzik.Wypozyczalnia.DTO.UserCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.UserUpdateDTO;
import com.wypochodzik.Wypozyczalnia.Entities.UserEntity;

public interface UsersService {

    UserEntity getUser(Long userId);
    UserEntity createUser(UserCreationDTO userCreationDTO);
    UserEntity updateUser(Long userId, UserUpdateDTO userUpdateDTO);
    void deleteUser(Long userId);
>>>>>>> c426f9754725fb855b9030ce0b6b4ca89c6781f9
}
