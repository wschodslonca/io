package com.wypochodzik.Wypozyczalnia.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "FavouritesACL")
public class FavouritesACLEntity {

    @Id
    private Long FavouritesACLid;
    private Long userId;
    private Long cardId;
}
