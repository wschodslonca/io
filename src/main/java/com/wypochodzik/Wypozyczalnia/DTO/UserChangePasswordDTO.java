package com.wypochodzik.Wypozyczalnia.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserChangePasswordDTO {

    @NotNull
    private String oldPass;

    @NotNull
    private String newPass;
}
