package com.wypochodzik.Wypozyczalnia.Entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "Admins")
public class AdminsEntity {

    @Id
    private Long adminId;
    private String email;
    private String passwd;
}
