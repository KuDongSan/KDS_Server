package dev.konkuk.home.domain.property.entity;

import dev.konkuk.home.domain.base.BaseTimeEntity;
import dev.konkuk.home.domain.property.constant.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Property extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Enumerated(EnumType.STRING)
    private SalesType salesType;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @ElementCollection
    @CollectionTable(
            name = "property_images",
            joinColumns = @JoinColumn(name = "property_id")
    )
    private List<String> images = new ArrayList<>();

    private String imageThumbnail;

    private Long deposit;

    private Long salePrice;

    private Long monthlyRentPrice;

    @Embedded
    private Area area;

    @Embedded
    private Address address;

    @Embedded
    private RoomType roomType;

    private String title;

    private String status;

    @Lob
    private String description;

    private String parking;

    private String elevator;

    private String roomDirection;

    private String moveinDate;

    @Embedded
    private Floor floor;

    private String options;

    private String manageCostInc;

    private Long bathroomCount;

    private String residenceType;

    private String manageCostNotInc;

    @Embedded
    private Popular popular;

//    private Boolean popular;

    @Embedded
    private Location location;

    private String agentTitle;

    private String agentPhone;

    private Double manageCost;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "subway_name1")),
            @AttributeOverride(name = "description", column = @Column(name = "description1")),
            @AttributeOverride(name = "distance", column = @Column(name = "subway_distance1"))
    })
    private Subway subway1;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "subway_name2")),
            @AttributeOverride(name = "description", column = @Column(name = "description2")),
            @AttributeOverride(name = "distance", column = @Column(name = "subway_distance2"))
    })
    private Subway subway2;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "subway_name3")),
            @AttributeOverride(name = "description", column = @Column(name = "description3")),
            @AttributeOverride(name = "distance", column = @Column(name = "subway_distance3")),
    })
    private Subway subway3;

    @Builder
    public Property(Long itemId, SalesType salesType, ServiceType serviceType,List<String> images, String imageThumbnail, Long deposit,
                    Long salePrice, Long monthlyRentPrice, Area area, Address address, RoomType roomType,
                    String title, String status, String description, String parking, String elevator,
                    String roomDirection, String moveinDate, Floor floor, String options, String manageCostInc,
                    Long bathroomCount, String residenceType, String manageCostNotInc, Popular popular, Location location,
                    String agentTitle, String agentPhone, Double manageCost, Subway subway1, Subway subway2, Subway subway3) {
        this.itemId = itemId;
        this.salesType = salesType;
        this.serviceType = serviceType;
        this.images = images;
        this.imageThumbnail = imageThumbnail;
        this.deposit = deposit;
        this.salePrice = salePrice;
        this.monthlyRentPrice = monthlyRentPrice;
        this.area = area;
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
        this.subway1 = subway1;
        this.subway2 = subway2;
        this.subway3 = subway3;
    }


}
