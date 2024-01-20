package com.dt.inse.application.service;

import com.dt.inse.application.DTO.InseQueryIn;
import com.dt.inse.application.DTO.InseQueryOut;
import com.dt.inse.application.DTO.aggregation.InseAggregationOut;
import com.dt.inse.domain.enumerations.TipoCapital;
import com.dt.inse.domain.enumerations.TipoLocalizacao;
import com.dt.inse.domain.enumerations.TipoRede;

public interface IInseService {
    InseQueryOut QueryInse(InseQueryIn in);

    InseAggregationOut AvgByState(Long UfCode);

    InseAggregationOut AvgByCityType(TipoCapital tipoCapital);

    InseAggregationOut AvgByCity(Long cityId);

    InseAggregationOut AvgByLocationType(TipoLocalizacao tipoLocalizacao);

    InseAggregationOut AvgByNetworkType(TipoRede tipoRede);
}
