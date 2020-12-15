package com.wypochodzik.Wypozyczalnia.Repositories;

import com.wypochodzik.Wypozyczalnia.Entities.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<CarsEntity,Long> {
}
