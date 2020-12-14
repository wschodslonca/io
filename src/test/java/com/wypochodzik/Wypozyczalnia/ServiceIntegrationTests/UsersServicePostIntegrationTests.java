package com.wypochodzik.Wypozyczalnia.ServiceIntegrationTests;

import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.UserAlreadyExistsException;
import com.wypochodzik.Wypozyczalnia.Repositories.UsersRepository;
import com.wypochodzik.Wypozyczalnia.Services.users.UsersServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.wypochodzik.Wypozyczalnia.DataProviders.UsersServiceIntegrationTestsDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsersServicePostIntegrationTests {

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        this.usersRepository.saveAll(usersEntities);
    }

    @Test
    void createUserTest() {
        UsersEntity newUserEntity = this.usersService.createUser(usersCreationDTO1);
        assertNotNull(newUserEntity);
        assertEquals(usersCreationDTO1.getEmail(), newUserEntity.getEmail());
        assertEquals(usersCreationDTO1.getName(), newUserEntity.getName());
        assertEquals(usersCreationDTO1.getSurname(), newUserEntity.getSurname());
        assertEquals(usersCreationDTO1.getAddress(), newUserEntity.getAddress());
        assertEquals(usersCreationDTO1.getTel(), newUserEntity.getTel());
        assertEquals(usersCreationDTO1.getPasswd(), newUserEntity.getPasswd());
        assertEquals(usersCreationDTO1.getBirthDate(), newUserEntity.getBirthDate());
        assertFalse(newUserEntity.isBanned());
        assertEquals(0.0, newUserEntity.getTotalPayed());
    }

}
