package com.wypochodzik.Wypozyczalnia.Controllers;

import com.wypochodzik.Wypozyczalnia.Entities.ServiceTechEntity;
import com.wypochodzik.Wypozyczalnia.Models.AdminSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class AdminsController {
    final private AdminSession adminSession;

    @Autowired
    public AdminsController(AdminSession adminSession) {
        this.adminSession = adminSession;
    }

    @GetMapping("/servicetechs")
    public List<ServiceTechEntity> getServiceTechs() {
        return adminSession.getAllServiceTechs();
    }
}
