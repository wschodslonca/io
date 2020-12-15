package com.wypochodzik.Wypozyczalnia.Controllers;

import com.wypochodzik.Wypozyczalnia.DTO.CarsDTO;
import com.wypochodzik.Wypozyczalnia.Models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/")
public class AdminsController {
    final private Admin admin;

    @Autowired
    public AdminsController(Admin admin) {
        this.admin = admin;
    }

    @PostMapping(value = "/cars")
    public void addCar(@RequestBody CarsDTO carsDTO) {
        admin.addCar(carsDTO);
    }
}
