package com.dt.inse.api;

import com.dt.inse.application.service.ILocationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inse")
public class LocationController {
    final ILocationService locationService;

    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }
}
