package com.dt.inse.application.service.impl;

import com.dt.inse.application.service.ILocationService;
import com.dt.inse.domain.model.location.City;
import com.dt.inse.domain.model.location.UF;
import com.dt.inse.infrastructure.JpaEntities.repository.LocationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LocationService implements ILocationService {

    final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<City> getCitiesByUfCode(Long UfCode) {
        var cities = locationRepository.findDistinctCityByCodUF(UfCode);
        if (!cities.isEmpty()) {
            return cities;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "city not found"
        );
    }

    @Override
    public List<UF> getUfs() {
        return locationRepository.findDistinctUF();
    }
}
