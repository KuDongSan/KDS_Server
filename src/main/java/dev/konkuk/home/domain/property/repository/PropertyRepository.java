package dev.konkuk.home.domain.property.repository;

import dev.konkuk.home.domain.property.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long>, CustomPropertyRepository{

    List<Property> findByAddress_Address2(String addr);

    @Query("select p from Property p "+
            "where p.itemId=:p1 or p.itemId=:p2")
    List<Property> findCompareProperty(Long p1, Long p2);
}
