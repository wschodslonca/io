package com.wypochodzik.Wypozyczalnia.ServiceIntegrationTests;


import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;
import com.wypochodzik.Wypozyczalnia.Repositories.UsersRepository;
import com.wypochodzik.Wypozyczalnia.Services.users.UsersServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.wypochodzik.Wypozyczalnia.DataProviders.UsersServiceIntegrationTestsDataProvider.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UsersServiceIntegrationTests {

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        this.usersRepository.saveAll(usersEntities);
    }

    @AfterEach
    void cleanUp() {
        this.usersRepository.deleteAll();
    }

    @Test
    void getUserTest() {
        UsersEntity userEntity = usersService.getUser(1L);
        assertEquals(userEntity.getUserId(), usersEntities.get(1).getUserId());
        assertEquals(userEntity.getEmail(), usersEntities.get(1).getEmail());
        assertEquals(userEntity.getName(), usersEntities.get(1).getName());
        assertEquals(userEntity.getPasswd(), usersEntities.get(1).getPasswd());
        assertEquals(userEntity.getSurname(), usersEntities.get(1).getSurname());
        assertEquals(userEntity.getAddress(), usersEntities.get(1).getAddress());
    }
}