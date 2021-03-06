package com.wypochodzik.Wypozyczalnia.ServiceIntegrationTests;

import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchUserException;
import com.wypochodzik.Wypozyczalnia.Repositories.UsersRepository;
import com.wypochodzik.Wypozyczalnia.Services.users.UsersServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.wypochodzik.Wypozyczalnia.DataProviders.UsersServiceIntegrationTestsDataProvider.usersEntities;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsersServiceGetIntegrationTests {

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        this.usersRepository.saveAll(usersEntities);
    }

    @Test
    void getUserNoSuchUserExceptionTest(){
        assertThrows(NoSuchUserException.class, () -> usersService.getUser(100L));
    }

    @Test
    void getUserTest() {
        Long userId = this.usersRepository.findAll().get(0).getUserId();
        UsersEntity userEntity = usersService.getUser(userId);
        assertNotNull(userEntity);
        assertEquals(userId,userEntity.getUserId());
        assertEquals(usersEntities.get(0).getEmail(),userEntity.getEmail());
        assertEquals(usersEntities.get(0).getName(),userEntity.getName());
        assertEquals(usersEntities.get(0).getPasswd(),userEntity.getPasswd());
        assertEquals(usersEntities.get(0).getSurname(),userEntity.getSurname());
        assertEquals(usersEntities.get(0).getAddress(),userEntity.getAddress());
        assertEquals(usersEntities.get(0).getTel(),userEntity.getTel());
        assertEquals(usersEntities.get(0).getBirthDate(),userEntity.getBirthDate());
        assertFalse(userEntity.isBanned());
        assertEquals(usersEntities.get(0).getTotalPayed(),userEntity.getTotalPayed());
        assertTrue(userEntity.isInfPromo());
        assertEquals(usersEntities.get(0).getCardData().get(0).getNumber(),userEntity.getCardData().get(0).getNumber());
        assertEquals(usersEntities.get(0).getDiscountRatio(),userEntity.getDiscountRatio());
    }
}