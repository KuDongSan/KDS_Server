package dev.konkuk.home.domain.property.api;

import dev.konkuk.home.domain.account.repository.AccountRepository;
import dev.konkuk.home.domain.property.dto.PropertyDto;
import dev.konkuk.home.domain.property.dto.PropertySimpleDto;
import dev.konkuk.home.domain.property.service.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "부동산 매물 Controller")
@RestController
@RequestMapping("/api/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;
    private final AccountRepository accountRepository;

    @ApiOperation(value = "지역구에 해당하는 전체 매물 반환하는 API")
    @ApiImplicitParam(name = "address", value = "지역구명", example = "송파구")
    @GetMapping
    public ResponseEntity<List<PropertySimpleDto>> getPropertyList(
            @RequestParam("address") String address
    ) {
        List<PropertySimpleDto> propertySimpleDtos = propertyService.getPropertyList(address);
        return ResponseEntity.ok(propertySimpleDtos);
    }

//    @GetMapping
//    public ResponseEntity<List<PropertySimpleDto>> getPropertyList(
//            @RequestParam("address") String address,
//            SearchDto searchDto
//    ) {
//        List<PropertySimpleDto> propertySimpleDtos = propertyService.getFilteredPropertyList(address, searchDto);
//
//        return ResponseEntity.ok(propertySimpleDtos);
//    }

    @ApiOperation(value = "매물 상세 정보를 반환하는 API")
    @ApiImplicitParam(name = "propertyId", value = "매물 아이디", example = "1")
    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertyDto> getProperty(@PathVariable Long propertyId) {
        PropertyDto propertyDto = propertyService.getProperty(propertyId);
        return ResponseEntity.ok(propertyDto);
    }

//    @ApiOperation(value = "매물 상세 정보를 반환하는 API")
//    @ApiImplicitParam(name = "propertyId", value = "매물 아이디", example = "1")
//    @GetMapping("/favorites")
//    public ResponseEntity<List<PropertySimpleDto>> getFavorites(
//            @RequestParam("email") String email
//    ) {
//
//        Optional<Account> byEmail = accountRepository.findByEmail(email);
//        byEmail.get().getProperties().add(3L);
//        byEmail.get().getProperties().add(4L);
//
//        List<PropertySimpleDto> favoritePropertyList = propertyService.getFavoritePropertyList(email);
//        return ResponseEntity.ok(favoritePropertyList);
//
//    }



}
