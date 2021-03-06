package com.wypochodzik.Wypozyczalnia.DTO;

import com.sun.istack.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersUpdateDTO {

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
}
