package dev.konkuk.home.domain.property.dto;

import dev.konkuk.home.domain.property.constant.Address;
import dev.konkuk.home.domain.property.constant.SalesType;
import dev.konkuk.home.domain.property.constant.ServiceType;
import dev.konkuk.home.domain.property.constant.Subway;
import dev.konkuk.home.domain.property.entity.Property;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class PropertySimpleDto {

    private Long itemId;

    private SalesType salesType;

    private ServiceType serviceType;

    private String image_thumbnail;

    private Double area;

    @Embedded
    private Address address;

    private List<Subway> subways = new ArrayList<>();

    @Builder
    public PropertySimpleDto(Long itemId, SalesType salesType, ServiceType serviceType, String image_thumbnail, Double area, Address address, List<Subway> subways) {
        this.itemId = itemId;
        this.salesType = salesType;
        this.serviceType = serviceType;
        this.image_thumbnail = image_thumbnail;
        this.area = area;
        this.address = address;
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
                .image_thumbnail(property.getImage_thumbnail())
                .area(property.getArea())
                .address(property.getAddress())
                .subways(subways)
                .build();
    }


}
