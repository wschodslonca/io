package com.wypochodzik.Wypozyczalnia.Repositories;

import com.wypochodzik.Wypozyczalnia.Entities.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceEntity,Long> {
}
