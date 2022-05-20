package dev.konkuk.home.domain.property.service;

import dev.konkuk.home.domain.account.entity.Account;
import dev.konkuk.home.domain.account.repository.AccountRepository;
import dev.konkuk.home.domain.property.dto.PropertyDto;
import dev.konkuk.home.domain.property.dto.PropertySimpleDto;
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
    //TODO 위치 변경
    private final AccountRepository accountRepository;


    public PropertyDto getProperty(Long propertyId) {
        Property property = propertyRepository.getById(propertyId);
        return PropertyDto.of(property, false);
    }

    public List<PropertySimpleDto> getFavoritePropertyList(String email) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(""));

        List<PropertySimpleDto> properties = account.getProperties().stream()
                .map(propertyId -> {
                    Property property = propertyRepository.findById(propertyId)
                            .orElseThrow(() -> new EntityNotFoundException(""));
                    return PropertySimpleDto.of(property);

                }).collect(Collectors.toList());

        return properties;
    }

    public List<PropertySimpleDto> getPropertyList(String addr) {
        List<Property> properties = propertyRepository.findByAddress_Address2(addr);

        return properties.parallelStream().map(property ->
                PropertySimpleDto.of(property)).collect(Collectors.toList());
    }


//    public List<PropertySimpleDto> getFilteredPropertyList(String addr, SearchDto searchDto) {
//        List<Property> properties = propertyRepository.findFilteredProPerty(addr, searchDto);
//
//        return properties.parallelStream().map(property ->
//                PropertySimpleDto.of(property)).collect(Collectors.toList());
//    }

    public Property getById(Long itemId) {
        return propertyRepository.getById(itemId);
    }
}
