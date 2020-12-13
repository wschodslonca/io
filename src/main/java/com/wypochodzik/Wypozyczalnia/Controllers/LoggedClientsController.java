package com.wypochodzik.Wypozyczalnia.Controllers;

import com.wypochodzik.Wypozyczalnia.DTO.OrdersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.OrdersDTO;
import com.wypochodzik.Wypozyczalnia.Models.LoggedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lc/")
public class LoggedClientsController {
    private final LoggedClient loggedClient;

    @Autowired
    public LoggedClientsController(LoggedClient loggedClient) {
        this.loggedClient = loggedClient;
    }

    @PostMapping("/makeorder")
    public ResponseEntity<OrdersDTO> makeOrder(@RequestBody OrdersCreationDTO ordersCreationDTO) {
        return new ResponseEntity<>(this.loggedClient.makeOrder(ordersCreationDTO), HttpStatus.CREATED);
    }
}
