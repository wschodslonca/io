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

public class UsersServiceIntegrationTestsDataProvider {

    public static UsersEntity usersEntity;
    public static UsersEntity usersEntity1;
    public static UsersEntity usersEntity2;
    public static UsersEntity usersEntity3;
    public static UsersCreationDTO usersCreationDTO;
    public static UsersCreationDTO usersCreationDTO1;
    public static final CreditCard creditCard;
    public static List<CreditCard> creditCardList;
    public static UsersUpdateDTO usersUpdateDTO;
    public static UserChangePasswordDTO userChangePasswordDTO;
    public static List<UsersEntity> usersEntities;
    static {
        creditCard = CreditCard.builder().number("123412341234").cvc(123).date("2020-12-12").build();
        creditCardList = new ArrayList<>();
        creditCardList.add(creditCard);

        usersEntity = UsersEntity.builder().userId(0L).email("user0_email").name("user0_name").surname("user0_surname")
                .address("user0_address").tel("000000000").passwd("user0_passwd").birthDate(new Date(2000, Calendar.JANUARY,12))
                .totalPayed(0.0).isBanned(false).infPromo(true).discountRatio(0.5).cardData(creditCardList).build();
        usersEntity1 = UsersEntity.builder().userId(1L).email("user1_email").name("user1_name").surname("user1_surname")
                .address("user1_address").tel("111111111").passwd("user1_passwd").birthDate(new Date(2000, Calendar.JANUARY,12))
                .totalPayed(0.0).isBanned(false).infPromo(true).discountRatio(0.5).cardData(creditCardList).build();

        usersEntity2 = UsersEntity.builder().userId(2L).email("user2_email").name("user2_name").surname("user2_surname")
                .address("user2_address").tel("222222222").passwd("user2_passwd").birthDate(new Date(2000, Calendar.JANUARY,12))
                .totalPayed(0.0).isBanned(false).infPromo(true).discountRatio(0.5).cardData(creditCardList).build();

        usersEntity3 = UsersEntity.builder().userId(3L).email("user3_email").name("user3_name").surname("user3_surname")
                .address("user3_address").tel("333333333").passwd("user3_passwd").birthDate(new Date(2000, Calendar.JANUARY,12))
                .totalPayed(0.0).isBanned(false).infPromo(true).discountRatio(0.5).cardData(creditCardList).build();

        usersEntities = new ArrayList<>();
        usersEntities.add(usersEntity);
        usersEntities.add(usersEntity1);
        usersEntities.add(usersEntity2);
        usersEntities.add(usersEntity3);

        usersCreationDTO = UsersCreationDTO.builder().email("user0_email").name("new_name").surname("new_surname").tel("123456789")
                .passwd("new_pass").address("new_address").birthDate(new Date(2000, Calendar.JANUARY,12)).build();

        usersCreationDTO1 = UsersCreationDTO.builder().email("new_email1").name("new_name").surname("new_surname").tel("123456789")
                .passwd("new_pass").address("new_address").birthDate(new Date(2000, Calendar.JANUARY,12)).build();

        usersUpdateDTO = UsersUpdateDTO.builder().name("new_name").surname("new_surname").tel("123456789")
                .address("new_address").birthDate(new Date(2000, Calendar.JANUARY,12)).build();

        userChangePasswordDTO = UserChangePasswordDTO.builder().oldPass("test_passwd").newPass("new_pass").build();
    }
}
