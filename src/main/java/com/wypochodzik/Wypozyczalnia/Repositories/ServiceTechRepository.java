package com.wypochodzik.Wypozyczalnia.Repositories;

import com.wypochodzik.Wypozyczalnia.Entities.ServiceTechEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTechRepository extends JpaRepository<ServiceTechEntity,Long> {
    ServiceTechEntity findByEmail(String email);
}
