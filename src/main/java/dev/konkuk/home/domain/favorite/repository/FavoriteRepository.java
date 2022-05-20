package dev.konkuk.home.domain.favorite.repository;

import dev.konkuk.home.domain.account.entity.Account;
import dev.konkuk.home.domain.favorite.entity.Favorite;
import dev.konkuk.home.domain.property.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    Optional<Favorite> findByAccountAndProperty(Account account, Property property);

    List<Favorite> findAllByAccount(Account account);

}
