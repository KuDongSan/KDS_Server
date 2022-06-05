package dev.konkuk.home.domain.property.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class Area {

    private Double exclusiveArea;

    private Double supplyArea;

    public Area(Double exclusiveArea) {
        this.exclusiveArea = exclusiveArea;
    }

}
