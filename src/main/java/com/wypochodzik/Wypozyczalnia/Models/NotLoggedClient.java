package com.wypochodzik.Wypozyczalnia.Models;

import com.wypochodzik.Wypozyczalnia.DTO.CarsDTO;
import com.wypochodzik.Wypozyczalnia.Models.NotLoggedSession.CarBrowseNL;
import com.wypochodzik.Wypozyczalnia.Models.NotLoggedSession.Login;
import com.wypochodzik.Wypozyczalnia.Models.NotLoggedSession.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotLoggedClient {
    private final CarBrowseNL carBrowseNL;
    private final Login login;
    private final Register register;

    @Autowired
    public NotLoggedClient(CarBrowseNL carBrowseNL, Login login, Register register) {
        this.carBrowseNL = carBrowseNL;
        this.login = login;
        this.register = register;
    }

    public List<CarsDTO> browseCars() {
        return this.carBrowseNL.browseCars();
    }


}
