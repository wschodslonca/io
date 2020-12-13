package com.wypochodzik.Wypozyczalnia.DataProviders;

import com.wypochodzik.Wypozyczalnia.Entities.ServiceTechEntity;

import java.util.ArrayList;
import java.util.List;

public class ServiceTechServiceUnitTestDataProvider {

    public static final Long serviceTechId = 1L;
    public static ServiceTechEntity serviceTechEntity;
    public static ServiceTechEntity serviceTechEntity1;
    public static List<ServiceTechEntity> serviceTechEntityList;
    static {
        serviceTechEntity1 = ServiceTechEntity.builder().serviceTechId(serviceTechId).email("test_email").passwd("test_passwd").build();
        serviceTechEntity = ServiceTechEntity.builder().serviceTechId(serviceTechId).email("test_email").passwd("test_passwd").build();
        serviceTechEntityList = new ArrayList<>();
        serviceTechEntityList.add(serviceTechEntity);
        serviceTechEntityList.add(serviceTechEntity1);
    }
}
