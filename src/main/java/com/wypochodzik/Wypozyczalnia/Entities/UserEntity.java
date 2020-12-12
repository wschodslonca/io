package com.wypochodzik.Wypozyczalnia.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity {

    @Id
    private Long id;

    private String name;
}
