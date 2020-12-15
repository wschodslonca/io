package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.Entities.ServiceTechEntity;

import java.util.List;

public interface ServiceTechService {

    ServiceTechEntity getServiceTech(Long serviceTechId);
    List<ServiceTechEntity> getAllServiceTech();
    void deleteServiceTech(Long serviceTechId);

}
