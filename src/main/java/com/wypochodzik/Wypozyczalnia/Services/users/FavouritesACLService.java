package com.wypochodzik.Wypozyczalnia.Services.users;


import com.wypochodzik.Wypozyczalnia.DTO.FavouritesACLDTO;
import com.wypochodzik.Wypozyczalnia.Entities.FavouritesACLEntity;

import java.util.List;

public interface FavouritesACLService {
    List<FavouritesACLEntity> getFavouriteACLsByUser(Long userId);
    FavouritesACLEntity createFavouriteACL(FavouritesACLDTO favouritesACLDTO);
    void delFavouriteACL(FavouritesACLDTO favouritesACLDTO);
}
