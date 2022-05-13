package dev.konkuk.home.domain.property.dto;

import dev.konkuk.home.domain.property.constant.SalesType;
import dev.konkuk.home.domain.property.constant.ServiceType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchDto {

    private SalesType salesType;

    private ServiceType serviceType;

    private Double area;

//    private Long distance;

}
