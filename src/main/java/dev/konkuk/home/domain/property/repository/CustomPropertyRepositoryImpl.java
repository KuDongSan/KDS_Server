package dev.konkuk.home.domain.property.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.konkuk.home.domain.property.constant.SalesType;
import dev.konkuk.home.domain.property.constant.ServiceType;
import dev.konkuk.home.domain.property.dto.SearchDto;
import dev.konkuk.home.domain.property.entity.Property;
import dev.konkuk.home.domain.property.entity.QProperty;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomPropertyRepositoryImpl implements CustomPropertyRepository {

    private JPAQueryFactory queryFactory;

    public CustomPropertyRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Property> findFilteredProPerty(SearchDto searchDto) {

        System.out.println(searchDto.getNearestDistance());

        QProperty qProperty = QProperty.property;

        List<Property> properties = queryFactory
                .select(qProperty)
                .from(qProperty)
                .where(qProperty.address.address2.eq(searchDto.getAddress())
                        .and(serviceTypeEquals(searchDto.getServiceType()))
                        .and(salesTypeEquals(searchDto.getSalesType()))
                        .and(nearestDistance(
                                searchDto.getNearestDistance() == null ? null : searchDto.getNearestDistance()))
                        .and(betweenDeposit(
                                searchDto.getUpperDeposit() == null ? null : searchDto.getUpperDeposit(),
                                searchDto.getLowerDeposit() == null ? null : searchDto.getLowerDeposit()))
                        .and(betweenArea(
                                searchDto.getUpperArea() == null ? null : searchDto.getUpperArea(),
                                searchDto.getLowerArea() == null ? null : searchDto.getLowerArea()))
                        .and(betweenMonthlyRent(
                                searchDto.getUpperMonthlyRent() == null ? null : searchDto.getUpperMonthlyRent(),
                                searchDto.getLowerMonthlyRent() == null ? null : searchDto.getLowerMonthlyRent())))
                .fetch();

        return properties;
    }

    private BooleanExpression nearestDistance(Long distance) {

        if (distance == null) {
            return null;
        }

        return QProperty.property.subway1.distance.loe(distance * 60)
                .or(QProperty.property.subway2.distance.loe(distance * 60))
                .or(QProperty.property.subway3.distance.loe(distance * 60));

    }

    private BooleanExpression serviceTypeEquals(ServiceType serviceType) {
        return QProperty.property.serviceType.eq(serviceType);
    }

    private BooleanExpression salesTypeEquals(SalesType salesType) {
        return QProperty.property.salesType.eq(salesType);
    }

    private BooleanExpression betweenArea(Double upperArea, Double lowerArea) {
        return QProperty.property.area.exclusiveArea.between(upperArea, lowerArea);
    }

    private BooleanExpression betweenDeposit(Long upperDeposit, Long lowerDeposit) {

        if (upperDeposit == null && lowerDeposit == null) {
            return null;
        }

        return QProperty.property.deposit.between(upperDeposit, lowerDeposit);
    }

    private BooleanExpression betweenMonthlyRent(Long upperMonthlyRent, Long lowerMonthlyRent) {

        if (upperMonthlyRent == null && lowerMonthlyRent == null) {
            return null;
        }

        return QProperty.property.monthlyRentPrice.between(upperMonthlyRent, lowerMonthlyRent);
    }

}
