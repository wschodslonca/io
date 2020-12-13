package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.DTO.FavouritesACLDTO;
import com.wypochodzik.Wypozyczalnia.Entities.FavouritesACLEntity;
import com.wypochodzik.Wypozyczalnia.Repositories.FavouritesACLRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouritesACLServiceImpl implements FavouritesACLService {
    final private FavouritesACLRepository favouritesACLRepository;

    public FavouritesACLServiceImpl(FavouritesACLRepository favouritesACLRepository) {
        this.favouritesACLRepository = favouritesACLRepository;
    }

    @Override
    public List<FavouritesACLEntity> getFavouriteACLsByUser(Long userId) {
        //List<FavouritesACLEntity> favouritesACLEntities = this.favouritesACLRepository.findByUserId(userId);
        return this.favouritesACLRepository.findByUserId(userId);

    }

    @Override
    public FavouritesACLEntity createFavouriteACL(FavouritesACLDTO favouritesACLDTO) {
        return null;
    }

    @Override
    public void delFavouriteACL(FavouritesACLDTO favouritesACLDTO) {

    }
}
