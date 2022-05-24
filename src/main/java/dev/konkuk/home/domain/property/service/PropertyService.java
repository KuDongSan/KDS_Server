package dev.konkuk.home.domain.property.service;

import dev.konkuk.home.domain.account.entity.Account;
import dev.konkuk.home.domain.account.repository.AccountRepository;
import dev.konkuk.home.domain.property.dto.PropertyDto;
import dev.konkuk.home.domain.property.dto.PropertySimpleDto;
import dev.konkuk.home.domain.property.dto.SearchDto;
import dev.konkuk.home.domain.property.entity.Property;
import dev.konkuk.home.domain.property.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyDto getProperty(Long propertyId) {
        Property property = propertyRepository.getById(propertyId);
        return PropertyDto.of(property, false);
    }


    public List<PropertySimpleDto> getPropertyList(String addr) {
        List<Property> properties = propertyRepository.findByAddress_Address2(addr);

        return properties.parallelStream().map(property ->
                PropertySimpleDto.of(property)).collect(Collectors.toList());
    }


    public List<PropertySimpleDto> getFilteredPropertyList(SearchDto searchDto) {

        List<Property> properties = propertyRepository.findFilteredProPerty(searchDto);

        return properties.parallelStream().map(property ->
                PropertySimpleDto.of(property)).collect(Collectors.toList());

    }

    public Property getById(Long itemId) {
        return propertyRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("매물 조회 실패"));
    }
}
