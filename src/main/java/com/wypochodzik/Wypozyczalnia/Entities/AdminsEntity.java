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
@Table(name = "Admins")
public class AdminsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long adminId;
    private String email;
    private String passwd;
}
