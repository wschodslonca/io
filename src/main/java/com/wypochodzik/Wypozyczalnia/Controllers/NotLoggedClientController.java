package com.wypochodzik.Wypozyczalnia.Controllers;

import com.wypochodzik.Wypozyczalnia.DTO.CarsDTO;
import com.wypochodzik.Wypozyczalnia.Entities.CarsEntity;
import com.wypochodzik.Wypozyczalnia.Models.NotLoggedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nlc/")
public class NotLoggedClientController {
    private final NotLoggedClient notLoggedClient;

    @Autowired
    public NotLoggedClientController(NotLoggedClient notLoggedClient) {
        this.notLoggedClient = notLoggedClient;
    }

    @GetMapping("/browsecars")
    public ResponseEntity<List<CarsDTO>> browseCars() {
        return new ResponseEntity<>(this.notLoggedClient.browseCars(), HttpStatus.OK);
    }
}
