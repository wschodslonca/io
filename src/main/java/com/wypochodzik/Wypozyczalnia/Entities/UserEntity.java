package com.wypochodzik.Wypozyczalnia.Entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserEntity {

    @Id
    @NotNull
    private Long userId;

    @NotNull
    private String email;

    @NotNull
    private String passwd;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private Date birthDate;

    @NotNull
    private String tel;

    @NotNull
    private String address;

    private boolean intPromo;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<CreditCard> cardData;

    private double discountRatio;

    private boolean isBanned;

    private double totalPayed;
}
