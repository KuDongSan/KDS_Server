package dev.konkuk.home.domain.property.dto;


import dev.konkuk.home.domain.property.constant.*;
import dev.konkuk.home.domain.property.entity.Property;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "내 집 등록하기 DTO")
@Getter
@Setter
public class PropertyRegisterDto {

    private String imageThumbnail;

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
    public PropertyRegisterDto(String imageThumbnail,
                               String address,
                               Double area,
                               Double manageCost,
                               RoomType roomType,
                               SalesType salesType,
                               ServiceType serviceType,
                               Long deposit,
                               Long monthlyRentPrice,
                               Subway subway) {
        this.imageThumbnail = imageThumbnail;
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

    public Property toEntity() {
        return Property.builder()
                .salesType(salesType)
                .serviceType(serviceType)
                .roomType(roomType)
                .imageThumbnail(imageThumbnail)
                .area(new Area(area))
                .address(new Address(address))
                .deposit(deposit)
                .manageCost(manageCost)
                .monthlyRentPrice(monthlyRentPrice)
                .subway1(subway)
                .build();
    }

}
