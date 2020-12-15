package com.wypochodzik.Wypozyczalnia.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "Service")
public class ServiceEntity {

    @Id
    private Long serviceId;
    private Long carId;
    private String problemInfo;
    private Timestamp estimatedTime;
    private String status;
    private double price;
}
