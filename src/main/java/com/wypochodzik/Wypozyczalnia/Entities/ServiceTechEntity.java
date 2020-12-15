package com.wypochodzik.Wypozyczalnia.Entities;

import lombok.*;

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
