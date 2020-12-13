package com.wypochodzik.Wypozyczalnia.UnitTests;

import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.Entities.CreditCard;
import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchUserException;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.UserAlreadyExistsException;
import com.wypochodzik.Wypozyczalnia.Repositories.UsersRepository;
import com.wypochodzik.Wypozyczalnia.Services.users.UsersServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.*;

import static com.wypochodzik.Wypozyczalnia.DataProviders.UsersServiceUnitTestDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;
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
        MockitoAnnotations.initMocks(this);
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
        assertTrue(usersEntity1.isIntPromo());
        assertEquals(creditCardList,usersEntity1.getCardData());
        assertEquals(0.5,usersEntity1.getDiscountRatio());
    }

    @Test
    void getUserNoSuchUserExceptionTest(){
        when(usersRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(NoSuchUserException.class, () -> usersService.getUser(userId));
    }

    @Test
    void createUserAlreadyExixstExceptionTest(){
        when(usersRepository.findByEmail(userEmail)).thenReturn(usersEntity);
        assertThrows(UserAlreadyExistsException.class, () -> usersService.createUser(usersCreationDTO));
    }
}
