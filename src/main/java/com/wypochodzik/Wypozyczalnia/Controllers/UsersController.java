package com.wypochodzik.Wypozyczalnia.Controllers;

import com.wypochodzik.Wypozyczalnia.Services.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

}
