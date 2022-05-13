package dev.konkuk.home.domain.account.api;

import dev.konkuk.home.domain.account.dto.AccountDto;
import dev.konkuk.home.domain.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/login")
    public AccountDto login(@RequestBody AccountDto accountDto) {
        if (!accountService.isRegisteredAccount(accountDto.getEmail())) {
            accountService.registerAccount(accountDto);
        }
        return accountService.getAccountDto(accountDto.getEmail());
    }



}
