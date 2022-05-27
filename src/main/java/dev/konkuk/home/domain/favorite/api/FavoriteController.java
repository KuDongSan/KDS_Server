package dev.konkuk.home.domain.favorite.api;

import dev.konkuk.home.domain.account.entity.Account;
import dev.konkuk.home.domain.account.service.AccountService;
import dev.konkuk.home.domain.favorite.dto.FavoriteDto;
import dev.konkuk.home.domain.favorite.service.FavoriteService;
import dev.konkuk.home.domain.property.entity.Property;
import dev.konkuk.home.domain.property.service.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "관심 매물 API")
@RequiredArgsConstructor
@RequestMapping("/api/favorites")
@RestController
public class FavoriteController {

    private final FavoriteService favoriteService;
    private final AccountService accountService;
    private final PropertyService propertyService;

    @ApiOperation(value = "유저의 관심 매물 목록 조회 API")
    @ApiImplicitParam(name = "email", value = "유저 이메일")
    @GetMapping
    public List<FavoriteDto.Response> getFavorites(@RequestParam String email) {
        return favoriteService.getFavorites(email);
    }

    @ApiOperation(value = "관심 매물 등록 API", notes = "이미 등록된 매물일 경우 한 번 더 요청하면 취소 처리")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void createFavorite(@RequestBody FavoriteDto.Request favoriteRequestDto) {
        Account account = accountService.findByEmail(favoriteRequestDto.getEmail());
        Property property = propertyService.getById(favoriteRequestDto.getItemId());
        favoriteService.createFavorite(account, property);
    }

}
