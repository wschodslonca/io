package com.wypochodzik.Wypozyczalnia.Models;

import com.wypochodzik.Wypozyczalnia.Models.ServiceSession.ServicePanel;
import org.springframework.stereotype.Component;

@Component
public class ServiceTech {
    private final ServicePanel servicePanel;

    public ServiceTech(ServicePanel servicePanel) {
        this.servicePanel = servicePanel;
    }
}
