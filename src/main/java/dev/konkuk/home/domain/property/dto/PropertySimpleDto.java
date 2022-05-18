package dev.konkuk.home.domain.property.dto;

import dev.konkuk.home.domain.property.constant.Address;
import dev.konkuk.home.domain.property.constant.SalesType;
import dev.konkuk.home.domain.property.constant.ServiceType;
import dev.konkuk.home.domain.property.constant.Subway;
import dev.konkuk.home.domain.property.entity.Property;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class PropertySimpleDto {

    private Long itemId;

    private SalesType salesType;

    private ServiceType serviceType;

    private String image_thumbnail;

    private Long deposit;

    private Long monthlyRentPrice;

    private Double manageCost;

    private Double area;

    private String address;

    private List<Subway> subways = new ArrayList<>();

    @Builder
    public PropertySimpleDto(Long itemId, SalesType salesType, ServiceType serviceType,
                             String image_thumbnail, Double area, Address address,
                             Long deposit, Long monthlyRentPrice, Double manageCost, List<Subway> subways) {
        this.itemId = itemId;
        this.salesType = salesType;
        this.serviceType = serviceType;
        this.image_thumbnail = image_thumbnail;
        this.area = area;
        this.address = address.getFullAddress();
        this.deposit = deposit;
        this.monthlyRentPrice = monthlyRentPrice;
        this.manageCost = manageCost;
        this.subways = subways;
    }

    public static PropertySimpleDto of(Property property) {

        List<Subway> subways = new ArrayList<>();

        subways.add(property.getSubway1());
        subways.add(property.getSubway2());

        if (property.getSubway3() != null) {
            subways.add(property.getSubway3());
        }

        return PropertySimpleDto.builder()
                .itemId(property.getItemId())
                .salesType(property.getSalesType())
                .serviceType(property.getServiceType())
                .image_thumbnail(property.getImageThumbnail())
                .area(property.getArea().getExclusiveArea())
                .address(property.getAddress())
                .deposit(property.getDeposit())
                .manageCost(property.getManageCost())
                .monthlyRentPrice(property.getMonthlyRentPrice())
                .subways(subways)
                .build();
    }


}
