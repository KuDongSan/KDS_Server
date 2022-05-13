package dev.konkuk.home.domain.property.api;

import dev.konkuk.home.domain.property.dto.PropertyDto;
import dev.konkuk.home.domain.property.dto.PropertySimpleDto;
import dev.konkuk.home.domain.property.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;


    @GetMapping
    public ResponseEntity<List<PropertySimpleDto>> getPropertyList(
            @RequestParam("address") String address
    ) {
        List<PropertySimpleDto> propertySimpleDtos = propertyService.getPropertyList(address);
        return ResponseEntity.ok(propertySimpleDtos);
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertyDto> getProperty(@PathVariable Long propertyId) {
        PropertyDto propertyDto = propertyService.getProperty(propertyId);
        return ResponseEntity.ok(propertyDto);
    }



}
