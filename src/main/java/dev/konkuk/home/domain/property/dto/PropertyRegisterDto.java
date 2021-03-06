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

    private String title;

    private String description;

    private String imageThumbnail;

    private Address address;

    private Double area;

    private Double manageCost;

    private RoomType roomType;

    private SalesType salesType;

    private ServiceType serviceType;

    private Long deposit;

    private Long monthlyRentPrice;

    private Location location;

    private Double lat;

    private Double lng;

    @Builder
    public PropertyRegisterDto(String title,
                               String description,
                               String imageThumbnail,
                               Address address,
                               Double area,
                               Double manageCost,
                               RoomType roomType,
                               SalesType salesType,
                               ServiceType serviceType,
                               Long deposit,
                               Long monthlyRentPrice,
                               Double lat,
                               Double lng) {
        this.title = title;
        this.description = description;
        this.imageThumbnail = imageThumbnail;
        this.address = address;
        this.area = area;
        this.manageCost = manageCost;
        this.roomType = roomType;
        this.salesType = salesType;
        this.serviceType = serviceType;
        this.deposit = deposit;
        this.monthlyRentPrice = monthlyRentPrice;
        this.lat = lat;
        this.lng = lng;
    }

    public Property toEntity() {
        return Property.builder()
                .title(title)
                .description(description)
                .salesType(salesType)
                .serviceType(serviceType)
                .roomType(roomType)
                .imageThumbnail(imageThumbnail)
                .area(new Area(area))
                .address(address)
                .deposit(deposit)
                .manageCost(manageCost)
                .monthlyRentPrice(monthlyRentPrice)
                .location(new Location(lat, lng))
                .build();
    }

}
