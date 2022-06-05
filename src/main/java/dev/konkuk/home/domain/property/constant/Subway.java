package dev.konkuk.home.domain.property.constant;

import lombok.*;

import javax.persistence.Embeddable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@ToString
@Builder
public class Subway {

    private String name;

    private String description;

    private Integer distance;

}
