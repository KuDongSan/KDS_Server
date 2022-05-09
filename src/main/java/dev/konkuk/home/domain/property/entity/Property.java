package dev.konkuk.home.domain.property.entity;

import dev.konkuk.home.domain.property.constant.*;
import lombok.*;

import javax.persistence.*;

@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Long itemId;

    @Enumerated(EnumType.STRING)
    private SalesType salesType;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    private String image_thumbnail;

    private Integer deposit;

    private Integer salePrice;

    private Long monthlyRentPrice;

    private Double area;

    @Embedded
    private Address address;

    @Embedded
    private Location location;

    private String agentTitle;

    private String agentPhone;

    private Double manageCost;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "subway_name1")),
            @AttributeOverride(name = "distance", column = @Column(name = "subway_distance1")),
    })
    private Subway subway1;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "subway_name2")),
            @AttributeOverride(name = "distance", column = @Column(name = "subway_distance2")),
    })
    private Subway subway2;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "subway_name3")),
            @AttributeOverride(name = "distance", column = @Column(name = "subway_distance3")),
    })
    private Subway subway3;

    @Builder
    public Property(
            Long id, SalesType salesType, ServiceType serviceType,String image_thumbnail,
            Integer deposit, Integer salePrice, Long monthlyRentPrice, Double area, Address address,
            Location location, String agentTitle, String agentPhone,
            Double manageCost) {
        this.itemId = id;
        this.salesType = salesType;
        this.serviceType = serviceType;
        this.deposit = deposit;
        this.salePrice = salePrice;
        this.image_thumbnail = image_thumbnail;
        this.monthlyRentPrice = monthlyRentPrice;
        this.area = area;
        this.address = address;
        this.location = location;
        this.manageCost = manageCost;
        this.agentTitle = agentTitle;
        this.agentPhone = agentPhone;
    }
}
