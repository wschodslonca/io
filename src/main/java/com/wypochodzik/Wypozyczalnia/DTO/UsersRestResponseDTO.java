package com.wypochodzik.Wypozyczalnia.DTO;

import com.wypochodzik.Wypozyczalnia.Entities.CreditCard;
import java.util.Date;
import java.util.List;

public class UsersRestResponseDTO {

    private Long userId;

    private String email;

    private String name;

    private String surname;

    private Date birthDate;

    private String tel;

    private String address;

    private boolean intPromo;

    private List<CreditCard> cardData;

    private double discountRatio;

    private boolean isBanned;

    private double totalPayed;
}
