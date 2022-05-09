package dev.konkuk.home.domain.property.dto;

import dev.konkuk.home.domain.property.constant.*;
import dev.konkuk.home.domain.property.entity.Property;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
public class PropertyDto {

    private Long itemId;

    private SalesType salesType;

    private ServiceType serviceType;

    private String image_thumbnail;

    private Integer deposit;

    private Integer salePrice;

    private Long monthlyRentPrice;

    private Double area;

    private Address address;

    private Location location;

    private String agentTitle;

    private String agentPhone;

    private Double manageCost;

    private Subway subway1;

    private Subway subway2;

    private Subway subway3;

    @Builder
    public PropertyDto(Long itemId, SalesType salesType, ServiceType serviceType, String image_thumbnail,
                       Integer deposit, Integer salePrice, Long monthlyRentPrice, Double area, Address address,
                       Location location, String agentTitle, String agentPhone, Double manageCost,
                       Subway subway1, Subway subway2, Subway subway3) {
        this.itemId = itemId;
        this.salesType = salesType;
        this.serviceType = serviceType;
        this.image_thumbnail = image_thumbnail;
        this.deposit = deposit;
        this.salePrice = salePrice;
        this.monthlyRentPrice = monthlyRentPrice;
        this.area = area;
        this.address = address;
        this.location = location;
        this.agentTitle = agentTitle;
        this.agentPhone = agentPhone;
        this.manageCost = manageCost;
        this.subway1 = subway1;
        this.subway2 = subway2;
        this.subway3 = subway3;
    }

    public static PropertyDto of(Property property) {

        return PropertyDto.builder()
                .itemId(property.getItemId())
                .salesType(property.getSalesType())
                .serviceType(property.getServiceType())
                .image_thumbnail(property.getImage_thumbnail())
                .deposit(property.getDeposit())
                .salePrice(property.getSalePrice())
                .monthlyRentPrice(property.getMonthlyRentPrice())
                .area(property.getArea())
                .address(property.getAddress())
                .location(property.getLocation())
                .agentTitle(property.getAgentTitle())
                .agentPhone(property.getAgentPhone())
                .manageCost(property.getManageCost())
                .subway1(property.getSubway1())
                .subway2(property.getSubway2())
                .subway3(property.getSubway3())
                .build();
    }
}
