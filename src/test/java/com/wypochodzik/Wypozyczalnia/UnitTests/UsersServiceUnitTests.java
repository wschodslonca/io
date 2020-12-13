package com.wypochodzik.Wypozyczalnia.UnitTests;

<<<<<<< HEAD
=======
import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
>>>>>>> f0cd3c800a7100a7e90044247781327e45d8c915
import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.InvalidPasswordException;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchUserException;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.UserAlreadyExistsException;
import com.wypochodzik.Wypozyczalnia.Repositories.UsersRepository;
import com.wypochodzik.Wypozyczalnia.Services.users.UsersServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.*;

import static com.wypochodzik.Wypozyczalnia.DataProviders.UsersServiceUnitTestDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
public class UsersServiceUnitTests {

    @InjectMocks
    UsersServiceImpl usersService;

    @Mock
    ModelMapper modelMapper;

    @Mock
    UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUserTest(){
        when(usersRepository.findById(userId)).thenReturn(java.util.Optional.ofNullable(usersEntity));
        UsersEntity usersEntity1 = this.usersService.getUser(userId);
        assertNotNull(usersEntity1);
        assertEquals(1, usersEntity1.getUserId());
        assertEquals("test_user@gmail.com",usersEntity1.getEmail());
        assertEquals("test_name",usersEntity1.getName());
        assertEquals("test_surname",usersEntity1.getSurname());
        assertEquals("test_address",usersEntity1.getAddress());
        assertEquals("123456789",usersEntity1.getTel());
        assertEquals("test_passwd",usersEntity1.getPasswd());
        assertEquals(new Date(2000, Calendar.JANUARY,12),usersEntity1.getBirthDate());
        assertFalse(usersEntity1.isBanned());
        assertEquals(0.0,usersEntity1.getTotalPayed());
        assertTrue(usersEntity1.isInfPromo());
        assertEquals(creditCardList,usersEntity1.getCardData());
        assertEquals(0.5,usersEntity1.getDiscountRatio());
    }

    @Test
    void getUserNoSuchUserExceptionTest(){
        when(usersRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(NoSuchUserException.class, () -> usersService.getUser(userId));
    }

    @Test
    void createUserTest(){
        when(usersRepository.findByEmail("test1@test.com")).thenReturn(usersEntity);
        when(usersRepository.findByEmail("new_test_user@gmail.com")).thenReturn(null);

        when(modelMapper.map(any(UsersCreationDTO.class),any())).thenReturn(
                UsersEntity.builder().userId(1L)
                        .email("new_test_user@gmail.com").name("new_name").surname("new_surname").tel("123456789")
                .passwd("new_pass").address("new_address").birthDate(new Date(2000, Calendar.JANUARY,12)).build()

        );
        when(usersRepository.save(any(UsersEntity.class))).thenReturn(usersEntity1);
        UsersEntity newUserEntity = this.usersService.createUser(usersCreationDTO1);
        assertNotNull(newUserEntity);
        assertEquals(1, newUserEntity.getUserId());
        assertEquals("new_test_user@gmail.com",newUserEntity.getEmail());
        assertEquals("new_name",newUserEntity.getName());
        assertEquals("new_surname",newUserEntity.getSurname());
        assertEquals("new_address",newUserEntity.getAddress());
        assertEquals("123456789",newUserEntity.getTel());
        assertEquals("new_pass",newUserEntity.getPasswd());
        assertEquals(new Date(2000, Calendar.JANUARY,12),newUserEntity.getBirthDate());
        assertFalse(usersEntity1.isBanned());
        assertEquals(0.0,usersEntity1.getTotalPayed());

    }
    @Test
    void createUserAlreadyExixstExceptionTest(){
        when(usersRepository.findByEmail(userEmail)).thenReturn(usersEntity);
        assertThrows(UserAlreadyExistsException.class, () -> usersService.createUser(usersCreationDTO));
    }

    @Test
    void updateUserTest(){
        when(usersRepository.findById(userId)).thenReturn(java.util.Optional.ofNullable(usersEntity));
        when(modelMapper.map(any(UsersCreationDTO.class),any())).thenReturn(
                UsersEntity.builder().userId(1L)
                        .email("new_test_user@gmail.com").name("new_name").surname("new_surname").tel("123456789")
                        .passwd("new_pass").address("new_address").birthDate(new Date(2000, Calendar.JANUARY,12)).build()

        );
        when(usersRepository.save(any(UsersEntity.class))).thenReturn(usersEntity1);
        UsersEntity newUserEntity = this.usersService.updateUser(userId,usersUpdateDTO);
        assertNotNull(newUserEntity);
        assertEquals(1, newUserEntity.getUserId());
        assertEquals("new_test_user@gmail.com",newUserEntity.getEmail());
        assertEquals("new_name",newUserEntity.getName());
        assertEquals("new_surname",newUserEntity.getSurname());
        assertEquals("new_address",newUserEntity.getAddress());
        assertEquals("123456789",newUserEntity.getTel());
        assertEquals("new_pass",newUserEntity.getPasswd());
        assertEquals(new Date(2000, Calendar.JANUARY,12),newUserEntity.getBirthDate());
    }

    @Test
    void updateUserNoSuchUserExceptionTest(){
        when(usersRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(NoSuchUserException.class, () -> usersService.updateUser(userId,usersUpdateDTO));
    }

    @Test
    void deleteUserTest() {
        Optional<UsersEntity> optionalUserEntity = Optional.of(usersEntity);

        when(usersRepository.findById(userId)).thenReturn(optionalUserEntity);

        usersService.deleteUser(userId);

        Mockito.verify(usersRepository, times(1)).delete(optionalUserEntity.get());
    }

    @Test
    void deleteUserNoSuchUserExceptionTest(){
        when(usersRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(NoSuchUserException.class, () -> usersService.deleteUser(userId));
    }

    @Test
    void changePasswordTest(){
        Optional<UsersEntity> optionalUserEntity = Optional.of(usersEntity2);
        when(usersRepository.findById(userId)).thenReturn(optionalUserEntity);
        when(usersRepository.save(any(UsersEntity.class))).thenReturn(usersEntity1);
        UsersEntity newUserEntity = this.usersService.changePassword(userId,userChangePasswordDTO);
        assertNotNull(newUserEntity);
        assertEquals("new_pass",newUserEntity.getPasswd());
    }

    @Test
    void changePasswordUserNoSuchUserExceptionTest(){
        when(usersRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(NoSuchUserException.class, () -> usersService.changePassword(userId,userChangePasswordDTO));
    }

    @Test
    void changePasswordUserInvalidPasswordExceptionTest(){
        when(usersRepository.findById(userId)).thenReturn(Optional.ofNullable(usersEntity1));
        assertThrows(InvalidPasswordException.class, () -> usersService.changePassword(userId,userChangePasswordDTO));
    }

}
