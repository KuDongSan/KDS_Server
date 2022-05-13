package dev.konkuk.home.domain.property.api;

import dev.konkuk.home.domain.account.dto.AccountDto;
import dev.konkuk.home.domain.account.entity.Account;
import dev.konkuk.home.domain.account.repository.AccountRepository;
import dev.konkuk.home.domain.account.service.AccountService;
import dev.konkuk.home.domain.property.dto.PropertyDto;
import dev.konkuk.home.domain.property.dto.PropertySimpleDto;
import dev.konkuk.home.domain.property.dto.SearchDto;
import dev.konkuk.home.domain.property.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;
    private final AccountRepository accountRepository;


    @GetMapping
    public ResponseEntity<List<PropertySimpleDto>> getPropertyList(
            @RequestParam("address") String address,
            SearchDto searchDto
    ) {
        List<PropertySimpleDto> propertySimpleDtos = propertyService.getFilteredPropertyList(address, searchDto);
        return ResponseEntity.ok(propertySimpleDtos);
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertyDto> getProperty(@PathVariable Long propertyId) {
        PropertyDto propertyDto = propertyService.getProperty(propertyId);
        return ResponseEntity.ok(propertyDto);
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<PropertySimpleDto>> getFavorites(
            @RequestParam("email") String email
    ) {
        Optional<Account> byEmail = accountRepository.findByEmail(email);
        byEmail.get().getProperties().add(3L);
        byEmail.get().getProperties().add(4L);


        List<PropertySimpleDto> favoritePropertyList = propertyService.getFavoritePropertyList(email);
        return ResponseEntity.ok(favoritePropertyList);

    }



}
