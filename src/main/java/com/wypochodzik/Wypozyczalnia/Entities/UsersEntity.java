package com.wypochodzik.Wypozyczalnia.Entities;

import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name = "Users")
public class UsersEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
