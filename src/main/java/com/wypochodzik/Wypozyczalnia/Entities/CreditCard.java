package com.wypochodzik.Wypozyczalnia.Entities;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

    public String number;
    public int cvc;
    public String date;
}
