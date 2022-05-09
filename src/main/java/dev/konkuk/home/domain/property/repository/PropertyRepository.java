package dev.konkuk.home.domain.property.repository;

import dev.konkuk.home.domain.property.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByAddress_Address2(String addr);
}
