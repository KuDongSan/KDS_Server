package dev.konkuk.home.domain.account.service;

import dev.konkuk.home.domain.account.dto.AccountDto;
import dev.konkuk.home.domain.account.entity.Account;
import dev.konkuk.home.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public boolean isRegisteredAccount(String email) {
        return accountRepository.existsByEmail(email);
    }

    public AccountDto getAccountDto(String email) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("유저 조회 실패"));
        return AccountDto.of(account);
    }

    @Transactional
    public AccountDto registerAccount(AccountDto accountDto) {
        Account account = accountDto.toEntity();
        account = Account.createAccount(account);
        Account savedAccount = accountRepository.save(account);
        return AccountDto.of(savedAccount);
    }

}
