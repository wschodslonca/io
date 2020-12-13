package com.wypochodzik.Wypozyczalnia.DataProviders;

import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.Entities.CreditCard;
import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UsersServiceUnitTestDataProvider {

    public static final Long userId = (long)1;
    public static UsersEntity usersEntity;
    public static final String userEmail = "test_user@gmail.com";
    public static UsersCreationDTO usersCreationDTO;
    public static final CreditCard creditCard;
    public static List<CreditCard> creditCardList;
    static {
        creditCard = CreditCard.builder().number("123412341234").cvc(123).date("2020-12-12").build();
        creditCardList = new ArrayList<>();
        creditCardList.add(creditCard);
        usersEntity = UsersEntity.builder().userId(userId).email(userEmail).name("test_name").surname("test_surname")
                .address("test_address").tel("123456789").passwd("test_passwd").birthDate(new Date(2000, Calendar.JANUARY,12))
                .totalPayed(0.0).isBanned(false).infPromo(true).discountRatio(0.5).cardData(creditCardList).build();
        usersCreationDTO = UsersCreationDTO.builder().email(userEmail).name("new_name").surname("new_surname").tel("123456789")
                .passwd("new_pass").address("new_address").birthDate(new Date(2000, Calendar.JANUARY,12)).build();
    }
}
