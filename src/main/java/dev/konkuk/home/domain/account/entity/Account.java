package dev.konkuk.home.domain.account.entity;

import dev.konkuk.home.domain.base.BaseTimeEntity;
import dev.konkuk.home.domain.property.entity.Property;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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

//    @ElementCollection
//    @CollectionTable(
//            name = "account_properties",
//            joinColumns = @JoinColumn(name = "account_id")
//    )
//    private List<Long> properties = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private Property property;

    public void setProperty(Property property) {
        this.property = property;
    }


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
