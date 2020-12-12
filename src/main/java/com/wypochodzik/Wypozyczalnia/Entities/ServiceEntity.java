package com.wypochodzik.Wypozyczalnia.Entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
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

    private Long carId;
    private String problemInfo;
    private Timestamp estimatedTime;
    private String status;
    private double price;
}
