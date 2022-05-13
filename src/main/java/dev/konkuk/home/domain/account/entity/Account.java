package dev.konkuk.home.domain.account.entity;

<<<<<<< HEAD
import dev.konkuk.home.domain.property.entity.Property;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Account")
@Entity
@AllArgsConstructor
@Builder
public class Account {
=======
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
>>>>>>> 26bf5f8feaa060760f68b32e77b6bb71d8092ee6

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    private String imageThumbnail;

<<<<<<< HEAD
    @ElementCollection
    @CollectionTable(
            name = "account_properties",
            joinColumns = @JoinColumn(name = "account_id")
    )
    private List<Integer> properties = new ArrayList<>();

=======
>>>>>>> 26bf5f8feaa060760f68b32e77b6bb71d8092ee6
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
