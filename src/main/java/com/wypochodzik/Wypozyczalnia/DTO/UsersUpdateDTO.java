package com.wypochodzik.Wypozyczalnia.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
