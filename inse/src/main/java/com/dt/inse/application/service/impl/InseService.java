package com.dt.inse.application.service.impl;

import com.dt.inse.application.DTO.InseQueryIn;
import com.dt.inse.application.DTO.InseQueryOut;
import com.dt.inse.application.DTO.aggregation.InseAggregationOut;
import com.dt.inse.application.gateways.IAggregations;
import com.dt.inse.application.gateways.IPagedQuery;
import com.dt.inse.application.service.IInseService;
import com.dt.inse.domain.enumerations.TipoCapital;
import com.dt.inse.domain.enumerations.TipoLocalizacao;
import com.dt.inse.domain.enumerations.TipoRede;
import com.dt.inse.domain.model.Inse;
import com.dt.inse.domain.pagination.Pagination;
import com.dt.inse.infrastructure.JpaEntities.repository.InseRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class InseService implements IInseService {

    final InseRepository inseRepository;
    final IPagedQuery pagedQuery;
    final IAggregations aggregations;


    public InseService(InseRepository inseRepository, IPagedQuery pagedQuery, IAggregations aggregations) {
        this.inseRepository = inseRepository;
        this.pagedQuery = pagedQuery;
        this.aggregations = aggregations;
    }

    @Override
    public InseQueryOut QueryInse(InseQueryIn in) {
        return pagedQuery.QueryInse(in);
    }

    @Override
    public InseAggregationOut AvgByState(Long UfCode) {
        var mapl = new HashMap<String, Long>();
        mapl.put("CodUF", UfCode);
        return aggregations.AvgAggregate(mapl);

    }


    @Override
    public InseAggregationOut AvgByCityType(TipoCapital tipoCapital) {
        var mapl = new HashMap<String, Long>();
        mapl.put("tipoCapital", tipoCapital.code.longValue());
        return aggregations.AvgAggregate(mapl);
    }

    @Override
    public InseAggregationOut AvgByCity(Long cityId) {
        var mapl = new HashMap<String, Long>();
        mapl.put("codMunicipio", cityId);
        return aggregations.AvgAggregate(mapl);
    }


    @Override
    public InseAggregationOut AvgByLocationType(TipoLocalizacao tipoLocalizacao) {
        var mapl = new HashMap<String, Long>();
        mapl.put("tipoLocalizacao", tipoLocalizacao.code.longValue());
        return aggregations.AvgAggregate(mapl);
    }

    @Override
    public InseAggregationOut AvgByNetworkType(TipoRede tipoRede) {
        var mapl = new HashMap<String, Long>();
        mapl.put("tipoRede", tipoRede.code.longValue());
        return aggregations.AvgAggregate(mapl);
    }


}
