package dev.konkuk.home.domain.favorite.service;

import dev.konkuk.home.domain.account.entity.Account;
import dev.konkuk.home.domain.account.service.AccountService;
import dev.konkuk.home.domain.favorite.dto.FavoriteDto;
import dev.konkuk.home.domain.favorite.entity.Favorite;
import dev.konkuk.home.domain.favorite.repository.FavoriteRepository;
import dev.konkuk.home.domain.property.entity.Property;
import dev.konkuk.home.domain.property.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final AccountService accountService;

    public List<FavoriteDto.Response> getFavorites(String email) {
        Account account = accountService.findByEmail(email);
        return favoriteRepository.findAllByAccount(account).stream()
                .map(FavoriteDto.Response::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public void createFavorite(Account account, Property property) {
        /* 이미 등록해놨을 경우 취소(삭제), 아닐 경우 관심 매물 등록 진행 */
        favoriteRepository.findByAccountAndProperty(account, property)
                .ifPresentOrElse(favoriteRepository::delete,
                        () -> {
                            Favorite favorite = Favorite.of(account, property);
                            favorite = Favorite.createFavorite(favorite);
                            favoriteRepository.save(favorite);
                        });
    }

    public boolean isFavorite(Account account, Property property) {
        return favoriteRepository.findByAccountAndProperty(account, property).isPresent();
    }

}
