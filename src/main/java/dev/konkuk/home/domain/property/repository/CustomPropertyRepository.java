package dev.konkuk.home.domain.property.repository;

import dev.konkuk.home.domain.property.dto.SearchDto;
import dev.konkuk.home.domain.property.entity.Property;

import java.util.List;

public interface CustomPropertyRepository {

    List<Property> findFilteredProPerty(String addr, SearchDto searchDto);

}
