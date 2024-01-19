package com.dt.inse.application.service;

import com.dt.inse.application.DTO.InseQueryIn;
import com.dt.inse.application.DTO.aggregation.InseAggregationOut;
import com.dt.inse.domain.enumerations.TipoCapital;
import com.dt.inse.domain.enumerations.TipoLocalizacao;
import com.dt.inse.domain.model.Inse;
import com.dt.inse.domain.pagination.Pagination;

public interface IInseService {
    Pagination<Inse> QueryInse(InseQueryIn in);

    InseAggregationOut AvgByState(Long UfCode);

    InseAggregationOut MedianByState(Long UfCode);

    InseAggregationOut AvgByCityType(TipoCapital tipoCapital);

    InseAggregationOut MedianByCityType(TipoCapital tipoCapital);

    InseAggregationOut AvgByLocationType(TipoLocalizacao tipoLocalizacao);

    InseAggregationOut MedianByLocationType(TipoLocalizacao tipoLocalizacao);


}
