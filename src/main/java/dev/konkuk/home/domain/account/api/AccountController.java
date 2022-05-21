package dev.konkuk.home.domain.account.api;

import dev.konkuk.home.domain.account.dto.AccountDto;
import dev.konkuk.home.domain.account.dto.RegisterPropertyDto;
import dev.konkuk.home.domain.account.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "소셜 로그인 Controller")
@RequestMapping("/api/user")
@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;

    @ApiOperation(value = "서버 로그인 API")
//    @ApiImplicitParam(name = "tagIds", value = "검색할 태그 ID를 담은 리스트", dataType = "list")
    @PostMapping("/login")
    public AccountDto login(@RequestBody AccountDto accountDto) {
        if (!accountService.isRegisteredAccount(accountDto.getEmail())) {
            accountService.registerAccount(accountDto);
        }
        return accountService.getAccountDto(accountDto.getEmail());
    }

    @ApiOperation(value = "내 부동산 등록 API")
    @PostMapping("/register")
    public ResponseEntity<RegisterPropertyDto.Response> registerProperty(
            @RequestParam String email,
            @RequestBody RegisterPropertyDto.Request dto) {

        RegisterPropertyDto.Response response = accountService.registerProperty(email, dto.getItemId());
        return ResponseEntity.ok(response);

    }



}
