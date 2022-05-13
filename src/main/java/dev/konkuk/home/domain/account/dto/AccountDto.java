package dev.konkuk.home.domain.account.dto;

import dev.konkuk.home.domain.account.entity.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@Builder
public class AccountDto {

    private String name;
    private String email;
    private String imageThumbnail;

    public Account toEntity() {

        return Account.builder()
                .name(name)
                .email(email)
                .imageThumbnail(imageThumbnail)
                .build();
    }

    public static AccountDto of(Account account) {
        return AccountDto.builder()
                .name(account.getName())
                .email(account.getEmail())
                .imageThumbnail(account.getImageThumbnail())
                .build();
    }

}
