package dev.konkuk.home.domain.subway.repository;

import dev.konkuk.home.domain.subway.entity.Subway;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubwayRepository extends JpaRepository<Subway, Long> {
}
