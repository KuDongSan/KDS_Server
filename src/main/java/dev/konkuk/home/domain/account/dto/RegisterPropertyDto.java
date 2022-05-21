package dev.konkuk.home.domain.account.dto;

import dev.konkuk.home.domain.favorite.dto.FavoriteDto;
import dev.konkuk.home.domain.favorite.entity.Favorite;
import dev.konkuk.home.domain.property.constant.SalesType;
import dev.konkuk.home.domain.property.constant.ServiceType;
import dev.konkuk.home.domain.property.constant.Subway;
import dev.konkuk.home.domain.property.entity.Property;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class RegisterPropertyDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Request {
        private Long itemId;
    }

    @Getter @Setter
    @Builder
    public static class Response {

        private Long itemId;
        private SalesType salesType;
        private ServiceType serviceType;
        private String image_thumbnail;
        private Long deposit;
        private Long monthlyRentPrice;
        private Double manageCost;
        private Double area;
        private String address;
        private List<Subway> subways;

        public static RegisterPropertyDto.Response of(Property property) {
            List<Subway> subways = new ArrayList<>();
            subways.add(property.getSubway1());
            subways.add(property.getSubway2());

            if (property.getSubway3() != null) {
                subways.add(property.getSubway3());
            }

            return RegisterPropertyDto.Response.builder()
                    .itemId(property.getItemId())
                    .salesType(property.getSalesType())
                    .serviceType(property.getServiceType())
                    .image_thumbnail(property.getImageThumbnail())
                    .area(property.getArea().getExclusiveArea())
                    .address(property.getAddress().getFullAddress())
                    .deposit(property.getDeposit())
                    .manageCost(property.getManageCost())
                    .monthlyRentPrice(property.getMonthlyRentPrice())
                    .subways(subways)
                    .build();
        }
    }
}
