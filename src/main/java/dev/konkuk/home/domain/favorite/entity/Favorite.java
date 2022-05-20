package dev.konkuk.home.domain.favorite.entity;

import dev.konkuk.home.domain.account.entity.Account;
import dev.konkuk.home.domain.base.BaseTimeEntity;
import dev.konkuk.home.domain.property.entity.Property;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Favorite extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Property property;

    @Builder
    public Favorite(Account account, Property property) {
        this.account = account;
        this.property = property;
    }

    public static Favorite of(Account account, Property property) {
        return Favorite.builder()
                .account(account)
                .property(property)
                .build();
    }

    public static Favorite createFavorite(Favorite favorite) {
        return Favorite.builder()
                .account(favorite.getAccount())
                .property(favorite.getProperty())
                .build();
    }

}
