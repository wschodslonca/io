package com.wypochodzik.Wypozyczalnia.Models;

import com.wypochodzik.Wypozyczalnia.Entities.ServiceTechEntity;
import com.wypochodzik.Wypozyczalnia.Services.users.ServiceTechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminSession {
    private final ServiceTechService serviceTechService;

    @Autowired
    public AdminSession(ServiceTechService serviceTechService) {
        this.serviceTechService = serviceTechService;
    }

    public List<ServiceTechEntity> getAllServiceTechs() {
        return serviceTechService.getAllServiceTech();
    }
}
