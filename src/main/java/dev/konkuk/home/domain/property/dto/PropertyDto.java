package dev.konkuk.home.domain.property.dto;

import dev.konkuk.home.domain.property.constant.*;
import dev.konkuk.home.domain.property.entity.Property;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
public class PropertyDto {

    private Long itemId;

    private SalesType salesType;

    private ServiceType serviceType;

    private List<String> images;

    private String imageThumbnail;

    private Long deposit;

    private Long salePrice;

    private Long monthlyRentPrice;

    private Area area;

    private String jibunAddress;

    private String address;

    private RoomType roomType;

    private String title;

    private String status;

    private String description;

    private String parking;

    private String elevator;

    private String roomDirection;

    private String moveinDate;

    private Floor floor;

    private String options;

    private String manageCostInc;

    private Long bathroomCount;

    private String residenceType;

    private String manageCostNotInc;

    private Popular popular;

//    private Boolean popular;

    private Location location;

    private String agentTitle;

    private String agentPhone;

    private Double manageCost;

    private Boolean favorite;

    private LocalDateTime updateAt;

    private List<Subway> subways = new ArrayList<>();

    @Builder
    public PropertyDto(Long itemId, SalesType salesType, ServiceType serviceType,List<String> images,  String imageThumbnail, Long deposit,
                    Long salePrice, Long monthlyRentPrice, Area area, String jibunAddress, String address, RoomType roomType,
                    String title, String status, String description, String parking, String elevator,
                    String roomDirection, String moveinDate, Floor floor, String options, String manageCostInc,
                    Long bathroomCount, String residenceType, String manageCostNotInc, Popular popular, Location location,
                    String agentTitle, String agentPhone, Double manageCost,Boolean favorite, LocalDateTime updateAt, List<Subway> subways) {
        this.itemId = itemId;
        this.salesType = salesType;
        this.serviceType = serviceType;
        this.images = images;
        this.imageThumbnail = imageThumbnail;
        this.deposit = deposit;
        this.salePrice = salePrice;
        this.monthlyRentPrice = monthlyRentPrice;
        this.area = area;
        this.jibunAddress = jibunAddress;
        this.address = address;
        this.roomType = roomType;
        this.title = title;
        this.status = status;
        this.description = description;
        this.parking = parking;
        this.elevator = elevator;
        this.roomDirection = roomDirection;
        this.moveinDate = moveinDate;
        this.floor = floor;
        this.options = options;
        this.manageCostInc = manageCostInc;
        this.bathroomCount = bathroomCount;
        this.residenceType = residenceType;
        this.manageCostNotInc = manageCostNotInc;
        this.popular = popular;
        this.location = location;
        this.agentTitle = agentTitle;
        this.agentPhone = agentPhone;
        this.manageCost = manageCost;
        this.favorite = favorite;
        this.updateAt = updateAt;
        this.subways = subways;

    }

    public static PropertyDto of(Property property, Boolean favorite) {

        List<Subway> subways = new ArrayList<>();

        subways.add(property.getSubway1());
        subways.add(property.getSubway2());

        if (property.getSubway3() != null) {
            subways.add(property.getSubway3());
        }

        return PropertyDto.builder()
                .itemId(property.getItemId())
                .salesType(property.getSalesType())
                .serviceType(property.getServiceType())
                .images(property.getImages())
                .imageThumbnail(property.getImageThumbnail())
                .deposit(property.getDeposit())
                .salePrice(property.getSalePrice())
                .monthlyRentPrice(property.getMonthlyRentPrice())
                .area(property.getArea())
                .roomType(property.getRoomType())
                .title(property.getTitle())
                .status(property.getStatus())
                .description(property.getDescription())
                .parking(property.getParking())
                .elevator(property.getElevator())
                .roomDirection(property.getRoomDirection())
                .moveinDate(property.getMoveinDate())
                .floor(property.getFloor())
                .options(property.getOptions())
                .manageCostInc(property.getManageCostInc())
                .bathroomCount(property.getBathroomCount())
                .residenceType(property.getResidenceType())
                .manageCostNotInc(property.getManageCostNotInc())
                .popular(property.getPopular())
                .address(property.getAddress().getFullAddress())
                .jibunAddress(property.getAddress().getJibunAddress())
                .location(property.getLocation())
                .agentTitle(property.getAgentTitle())
                .agentPhone(property.getAgentPhone())
                .manageCost(property.getManageCost())
                .favorite(favorite)
                .updateAt(property.getModifiedAt())
                .subways(subways)
                .build();
    }
}
