package dev.konkuk.home.domain.account.dto;

import dev.konkuk.home.domain.account.entity.Account;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "로그인 시 서버에 보낼 정보")
@Getter @Setter
@Builder
public class AccountDto {

    @ApiModelProperty(value = "회원 이름", example = "윤영진")
    private String name;

    @ApiModelProperty(value = "회원 이메일", example = "dudwls143@gmail.com")
    private String email;

    @ApiModelProperty(value = "회원 사진")
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
