package com.wypochodzik.Wypozyczalnia.ServiceIntegrationTests;

import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchUserException;
import com.wypochodzik.Wypozyczalnia.Repositories.UsersRepository;
import com.wypochodzik.Wypozyczalnia.Services.users.UsersServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.wypochodzik.Wypozyczalnia.DataProviders.UsersServiceIntegrationTestsDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsersServiceDeleteIntegrationTests {

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        this.usersRepository.deleteAll();
        this.usersRepository.saveAll(usersEntities);
    }

    @Test
    void deleteUserTest() {
        Long userId = this.usersRepository.findAll().get(0).getUserId();
        usersService.deleteUser(userId);
        assertEquals(Optional.empty(),usersRepository.findById(userId));
    }

    @Test
    void deleteUserNoSuchUserExceptionTest(){
        assertThrows(NoSuchUserException.class, () -> usersService.deleteUser(100L));
    }
}
