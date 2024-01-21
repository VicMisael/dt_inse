package com.dt.inse.api;

import com.dt.inse.application.service.ILocationService;
import com.dt.inse.domain.model.location.City;
import com.dt.inse.domain.model.location.UF;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("location")
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {
    final ILocationService locationService;

    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("uf")
    public List<UF> getUfs() {
        return locationService.getUfs();
    }

    @GetMapping("uf/{id}/cities")
    public List<City> getUfs(@PathVariable Long id) {
        return locationService.getCitiesByUfCode(id);
    }

}
