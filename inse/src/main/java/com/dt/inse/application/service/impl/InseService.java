package com.dt.inse.application.service.impl;

import com.dt.inse.application.DTO.InseQueryIn;
import com.dt.inse.application.DTO.aggregation.InseAggregationOut;
import com.dt.inse.application.service.IInseService;
import com.dt.inse.domain.enumerations.TipoCapital;
import com.dt.inse.domain.enumerations.TipoLocalizacao;
import com.dt.inse.domain.model.Inse;
import com.dt.inse.domain.pagination.Pagination;
import com.dt.inse.infrastructure.JpaEntities.repository.InseRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class InseService implements IInseService {

    final InseRepository inseRepository;

    public InseService(InseRepository inseRepository) {
        this.inseRepository = inseRepository;
    }

    @Override
    public Pagination<Inse> QueryInse(InseQueryIn in) {
        var sort = Sort.by();
    }

    @Override
    public InseAggregationOut AvgByState(Long UfCode) {
        return null;
    }

    @Override
    public InseAggregationOut MedianByState(Long UfCode) {
        return null;
    }

    @Override
    public InseAggregationOut AvgByCityType(TipoCapital tipoCapital) {
        return null;
    }

    @Override
    public InseAggregationOut MedianByCityType(TipoCapital tipoCapital) {
        return null;
    }

    @Override
    public InseAggregationOut AvgByLocationType(TipoLocalizacao tipoLocalizacao) {
        return null;
    }

    @Override
    public InseAggregationOut MedianByLocationType(TipoLocalizacao tipoLocalizacao) {
        return null;
    }
}
