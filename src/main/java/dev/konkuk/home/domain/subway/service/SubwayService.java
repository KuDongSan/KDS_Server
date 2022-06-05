package dev.konkuk.home.domain.subway.service;

import dev.konkuk.home.domain.subway.dto.SubwayDto;
import dev.konkuk.home.domain.subway.entity.Subway;
import dev.konkuk.home.domain.subway.repository.SubwayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SubwayService {

    private final SubwayRepository subwayRepository;

    public SubwayDto findNearestSubway(double lat, double lng) {
        double minDist = Double.MAX_VALUE;
        Subway nearestSubway = null;

        List<Subway> subways = subwayRepository.findAll();
        for (Subway subway : subways) {
            double theta = subway.getLng() - lng;
            double dist = Math.sin(deg2rad(subway.getLat())) * Math.sin(deg2rad(lat)) + Math.cos(deg2rad(subway.getLat())) * Math.cos(deg2rad(lat)) * Math.cos(deg2rad(theta));
            dist = Math.acos(dist);
            dist = rad2deg(dist);
            dist = dist * 60 * 1.1515 * 1609.344; // meter 단위
            if (dist < minDist) {
                minDist = dist;
                nearestSubway = subway;
            }
        }

        //도보 거리 계산 (분당 67m) -> 초로 변환
        Integer time = (int) (minDist / 67 * 60);

        if (nearestSubway == null) {
            return null;
        }

        return SubwayDto.builder()
                .name(nearestSubway.getName())
                .description(nearestSubway.getDescription().split(",")[0])
                .distance(time)
                .build();
    }

    //10진수를 radian(라디안)으로 변환
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    //radian(라디안)을 10진수로 변환
    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
