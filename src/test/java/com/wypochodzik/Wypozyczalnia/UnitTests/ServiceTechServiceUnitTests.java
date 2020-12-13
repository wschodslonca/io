package com.wypochodzik.Wypozyczalnia.UnitTests;

import com.wypochodzik.Wypozyczalnia.Entities.ServiceTechEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchUserException;
import com.wypochodzik.Wypozyczalnia.Repositories.ServiceTechRepository;
import com.wypochodzik.Wypozyczalnia.Services.users.ServiceTechServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static com.wypochodzik.Wypozyczalnia.DataProviders.ServiceTechServiceUnitTestDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
public class ServiceTechServiceUnitTests {

    @InjectMocks
    ServiceTechServiceImpl serviceTechService;

    @Mock
    ServiceTechRepository serviceTechRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getServiceTechTest(){
        when(serviceTechRepository.findById(serviceTechId)).thenReturn(java.util.Optional.ofNullable(serviceTechEntity));
        ServiceTechEntity serviceTechEntity = this.serviceTechService.getServiceTech(serviceTechId);
        assertNotNull(serviceTechEntity);
        assertEquals(1, serviceTechEntity.getServiceTechId());
        assertEquals("test_email",serviceTechEntity.getEmail());
        assertEquals("test_passwd",serviceTechEntity.getPasswd());
    }

    @Test
    void getServiceTechNoSuchUserExceptionTest(){
        when(serviceTechRepository.findById(serviceTechId)).thenReturn(Optional.empty());
        assertThrows(NoSuchUserException.class, () -> serviceTechService.getServiceTech(serviceTechId));
    }

    @Test
    void getAllUsers(){
        when(serviceTechRepository.findAll()).thenReturn(serviceTechEntityList);
        List<ServiceTechEntity> serviceTechEntities = this.serviceTechService.getAllServiceTech();
        assertEquals(serviceTechEntities.get(0),serviceTechEntity);
        assertEquals(serviceTechEntities.get(1),serviceTechEntity1);
    }

    @Test
    void deleteServiceTechTest() {
        Optional<ServiceTechEntity> optionalServiceTechEntity = Optional.of(serviceTechEntity);

        when(serviceTechRepository.findById(serviceTechId)).thenReturn(optionalServiceTechEntity);

        serviceTechService.deleteServiceTech(serviceTechId);

        Mockito.verify(serviceTechRepository, times(1)).delete(optionalServiceTechEntity.get());
    }

    @Test
    void deleteUserNoSuchUserExceptionTest(){
        when(serviceTechRepository.findById(serviceTechId)).thenReturn(Optional.empty());
        assertThrows(NoSuchUserException.class, () -> serviceTechService.deleteServiceTech(serviceTechId));
    }
}
