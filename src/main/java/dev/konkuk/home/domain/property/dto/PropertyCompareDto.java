package dev.konkuk.home.domain.property.dto;


import dev.konkuk.home.domain.property.constant.*;
import dev.konkuk.home.domain.property.entity.Property;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@ApiModel(value = "매물 비교 화면에 최적화된 Dto")
@Getter
@Setter
public class PropertyCompareDto {

    private String imageThumbnail;

    private Long itemId;

    private String address;

    private Double area;

    private Double manageCost;

    private RoomType roomType;

    private SalesType salesType;

    private ServiceType serviceType;

    private Long deposit;

    private Long monthlyRentPrice;

    private Subway subway;

    @Builder
    public PropertyCompareDto(String imageThumbnail, Long itemId, String address,
                              Double area, Double manageCost, RoomType roomType,
                              SalesType salesType, ServiceType serviceType,
                              Long deposit, Long monthlyRentPrice, Subway subway) {
        this.imageThumbnail = imageThumbnail;
        this.itemId = itemId;
        this.address = address;
        this.area = area;
        this.manageCost = manageCost;
        this.roomType = roomType;
        this.salesType = salesType;
        this.serviceType = serviceType;
        this.deposit = deposit;
        this.monthlyRentPrice = monthlyRentPrice;
        this.subway = subway;
    }

    public static PropertyCompareDto of(Property property) {

        List<Subway> subways = new ArrayList<>();

        subways.add(property.getSubway1());
        subways.add(property.getSubway2());

        if (property.getSubway3() != null) {
            subways.add(property.getSubway3());
        }

        Subway subway = getNearestSubway(subways);

        return PropertyCompareDto.builder()
                .itemId(property.getItemId())
                .salesType(property.getSalesType())
                .serviceType(property.getServiceType())
                .roomType(property.getRoomType())
                .imageThumbnail(property.getImageThumbnail())
                .area(property.getArea().getExclusiveArea())
                .address(property.getAddress().getMiddleAddress())
                .deposit(property.getDeposit())
                .manageCost(property.getManageCost())
                .monthlyRentPrice(property.getMonthlyRentPrice())
                .subway(subway)
                .build();
    }

    private static Subway getNearestSubway(List<Subway> subways) {

        return subways.stream()
                .min(Comparator.comparingInt(Subway::getDistance))
                .get();

    }
}
