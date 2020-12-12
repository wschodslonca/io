package com.wypochodzik.Wypozyczalnia.Entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "ServiceTech")
public class ServiceTechEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long serviceTechId;
    private String email;
    private String passwd;

}
