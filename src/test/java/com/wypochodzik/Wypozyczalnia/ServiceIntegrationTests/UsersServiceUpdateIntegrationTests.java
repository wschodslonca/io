package com.wypochodzik.Wypozyczalnia.ServiceIntegrationTests;

import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchUserException;
import com.wypochodzik.Wypozyczalnia.Repositories.UsersRepository;
import com.wypochodzik.Wypozyczalnia.Services.users.UsersServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

import static com.wypochodzik.Wypozyczalnia.DataProviders.UsersServiceIntegrationTestsDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsersServiceUpdateIntegrationTests {

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        this.usersRepository.saveAll(usersEntities);
    }

    @Test
    void updateUserTest(){
        UsersEntity newUserEntity = this.usersService.updateUser(1L,usersUpdateDTO);
        assertNotNull(newUserEntity);
        assertEquals(1, newUserEntity.getUserId());
        assertEquals("new_name",newUserEntity.getName());
        assertEquals("new_surname",newUserEntity.getSurname());
        assertEquals("new_address",newUserEntity.getAddress());
        assertEquals("123456789",newUserEntity.getTel());
        assertEquals(new Date(2000, Calendar.JANUARY,12),newUserEntity.getBirthDate());
    }

    @Test
    void updateUserNoSuchUserExceptionTest(){
        assertThrows(NoSuchUserException.class, () -> usersService.updateUser(100L,usersUpdateDTO));
    }
}
