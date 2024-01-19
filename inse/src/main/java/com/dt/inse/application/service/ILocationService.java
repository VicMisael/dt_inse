package com.dt.inse.application.service;

import com.dt.inse.domain.model.location.City;
import com.dt.inse.domain.model.location.UF;

import java.util.List;

public interface ILocationService {

    List<City> getCitiesByUfCode(Long UfCode);

    List<UF> getUfs();
}
