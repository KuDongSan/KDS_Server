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

public class CustomPropertyRepositoryImpl implements CustomPropertyRepository{

    private JPAQueryFactory queryFactory;

    public CustomPropertyRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Property> findFilteredProPerty(String addr, SearchDto searchDto) {
        QProperty qProperty = QProperty.property;

        List<Property> properties = queryFactory
                .select(qProperty)
                .from(qProperty)
                .where(qProperty.address.address2.eq(addr)
                        .and(serviceTypeEquals(searchDto.getServiceType()))
                        .and(salesTypeEquals(searchDto.getSalesType()))
                        .and(areaMoreThan(searchDto.getArea())))
                .fetch();

        return properties;
    }

    private BooleanExpression serviceTypeEquals(ServiceType serviceType) {
        return QProperty.property.serviceType.eq(serviceType);
    }

    private BooleanExpression salesTypeEquals(SalesType salesType) {
        return QProperty.property.salesType.eq(salesType);
    }

    private BooleanExpression areaMoreThan(Double area) {
        return QProperty.property.area.exclusiveArea.gt(area);
    }
}
