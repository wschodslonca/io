package com.wypochodzik.Wypozyczalnia.DataProviders;

import com.wypochodzik.Wypozyczalnia.DTO.UserChangePasswordDTO;
import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.UsersUpdateDTO;
import com.wypochodzik.Wypozyczalnia.Entities.CreditCard;
import com.wypochodzik.Wypozyczalnia.Entities.UsersEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UsersServiceUnitTestDataProvider {

    public static final Long userId = (long)1;
    public static UsersEntity usersEntity;
    public static UsersEntity usersEntity1;
    public static UsersEntity usersEntity2;
    public static final String userEmail = "test_user@gmail.com";
    public static UsersCreationDTO usersCreationDTO;
    public static UsersCreationDTO usersCreationDTO1;
    public static final CreditCard creditCard;
    public static List<CreditCard> creditCardList;
    public static UsersUpdateDTO usersUpdateDTO;
    public static UserChangePasswordDTO userChangePasswordDTO;
    static {
        creditCard = CreditCard.builder().number("123412341234").cvc(123).date("2020-12-12").build();
        creditCardList = new ArrayList<>();
        creditCardList.add(creditCard);
        usersEntity = UsersEntity.builder().userId(userId).email(userEmail).name("test_name").surname("test_surname")
                .address("test_address").tel("123456789").passwd("test_passwd").birthDate(new Date(2000, Calendar.JANUARY,12))
                .totalPayed(0.0).isBanned(false).infPromo(true).discountRatio(0.5).cardData(creditCardList).build();
        usersCreationDTO = UsersCreationDTO.builder().email(userEmail).name("new_name").surname("new_surname").tel("123456789")
                .passwd("new_pass").address("new_address").birthDate(new Date(2000, Calendar.JANUARY,12)).build();
        usersCreationDTO1 = UsersCreationDTO.builder().email("new_test_user@gmail.com").name("new_name").surname("new_surname").tel("123456789")
                .passwd("new_pass").address("new_address").birthDate(new Date(2000, Calendar.JANUARY,12)).build();
        usersEntity1 = UsersEntity.builder().userId(userId).email("new_test_user@gmail.com").name("new_name").surname("new_surname").tel("123456789")
                .passwd("new_pass").address("new_address").birthDate(new Date(2000, Calendar.JANUARY,12))
                .totalPayed(0.0).isBanned(false).intPromo(false).discountRatio(0.0).cardData(new ArrayList<>()).build();
        usersUpdateDTO = UsersUpdateDTO.builder().name("new_name").surname("new_surname").tel("123456789")
                .address("new_address").birthDate(new Date(2000, Calendar.JANUARY,12)).build();
        userChangePasswordDTO = UserChangePasswordDTO.builder().oldPass("test_passwd").newPass("new_pass").build();
        usersEntity2 = UsersEntity.builder().userId(userId).email(userEmail).name("test_name").surname("test_surname")
                .address("test_address").tel("123456789").passwd("test_passwd").birthDate(new Date(2000, Calendar.JANUARY,12))
                .totalPayed(0.0).isBanned(false).intPromo(true).discountRatio(0.5).cardData(creditCardList).build();
    }
}
