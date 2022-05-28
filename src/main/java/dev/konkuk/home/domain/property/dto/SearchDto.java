package dev.konkuk.home.domain.property.dto;

import dev.konkuk.home.domain.property.constant.SalesType;
import dev.konkuk.home.domain.property.constant.ServiceType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchDto {

    private String address;

    private SalesType salesType;

    private ServiceType serviceType;

    /**
     * upperArea < Area < lowerArea
     */
    private Double upperArea;

    private Double lowerArea;

    /**
     * upperDeposit < Deposit < lowerDeposit
     */
    private Long upperDeposit;

    private Long lowerDeposit;
    
    /**
     * ex. 지하철로부터 10분이내의 매물
     */
    private Long nearestDistance;

}
