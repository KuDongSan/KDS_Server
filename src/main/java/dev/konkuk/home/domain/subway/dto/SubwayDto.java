package dev.konkuk.home.domain.subway.dto;

import dev.konkuk.home.domain.property.constant.Subway;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SubwayDto {

    private String name;

    private String description;

    private Integer distance;

    public Subway toEmbeddable() {
        return Subway.builder()
                .name(name)
                .description(description)
                .distance(distance)
                .build();
    }

}
