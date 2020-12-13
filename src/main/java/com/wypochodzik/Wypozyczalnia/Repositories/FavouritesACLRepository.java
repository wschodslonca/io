package com.wypochodzik.Wypozyczalnia.Repositories;

import com.wypochodzik.Wypozyczalnia.Entities.FavouritesACLEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavouritesACLRepository extends JpaRepository<FavouritesACLEntity,Long> {
    public List<FavouritesACLEntity> findByUserId(Long userId);

}
