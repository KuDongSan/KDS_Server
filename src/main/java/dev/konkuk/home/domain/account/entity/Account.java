package dev.konkuk.home.domain.account.entity;

import dev.konkuk.home.domain.base.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    private String imageThumbnail;

    @Builder
    public Account(String name, String email, String imageThumbnail) {
        this.name = name;
        this.email = email;
        this.imageThumbnail = imageThumbnail;
    }

    public static Account createAccount(Account account) {
        return Account.builder()
                .name(account.getName())
                .email(account.getEmail())
                .imageThumbnail(account.getImageThumbnail())
                .build();
    }

}
