package com.wypochodzik.Wypozyczalnia.Models;

import com.wypochodzik.Wypozyczalnia.DTO.CarsDTO;
import com.wypochodzik.Wypozyczalnia.Models.AdminSession.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Admin {
    private final CarDBManagement carDBManagement;
    private final ClientAccManagement clientAccManagement;
    private final DiscountManagement discountManagement;
    private final MaintenanceManagement maintenanceManagement;
    private final OrderManagement orderManagement;
    private final StatisticsPanel statisticsPanel;

    @Autowired
    public Admin(CarDBManagement carDBManagement, ClientAccManagement clientAccManagement, DiscountManagement discountManagement, MaintenanceManagement maintenanceManagement, OrderManagement orderManagement, StatisticsPanel statisticsPanel) {
        this.carDBManagement = carDBManagement;
        this.clientAccManagement = clientAccManagement;
        this.discountManagement = discountManagement;
        this.maintenanceManagement = maintenanceManagement;
        this.orderManagement = orderManagement;
        this.statisticsPanel = statisticsPanel;
    }

    public void addCar(CarsDTO carsDTO) {
        this.carDBManagement.addCar(carsDTO);
    }

}
