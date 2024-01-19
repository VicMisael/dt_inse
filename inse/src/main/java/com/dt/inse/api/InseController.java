package com.dt.inse.api;

import com.dt.inse.application.DTO.InseQueryIn;
import com.dt.inse.application.DTO.aggregation.InseAggregationOut;
import com.dt.inse.application.service.IInseService;
import com.dt.inse.commons.QueryOrder;
import com.dt.inse.domain.enumerations.TipoCapital;
import com.dt.inse.domain.enumerations.TipoLocalizacao;
import com.dt.inse.domain.enumerations.TipoRede;
import com.dt.inse.domain.model.Inse;
import com.dt.inse.domain.pagination.Pagination;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("inse")
public class InseController {
    final IInseService InseService;

    public InseController(IInseService iInseService) {
        this.InseService = iInseService;
    }

    @GetMapping
    public Pagination<Inse> QueryInse(@RequestParam Optional<Integer> page,
                                      @RequestParam Optional<Integer> perPage,
                                      @RequestParam Optional<String> uf,
                                      @RequestParam Optional<QueryOrder> orderUf,
                                      @RequestParam Optional<String> municipio,
                                      @RequestParam Optional<QueryOrder> orderMunicipio,
                                      @RequestParam Optional<String> querySchoolName,
                                      @RequestParam Optional<QueryOrder> orderBySchoolName) {
        int perPageContent = perPage.orElse(10);
        int pageN = page.orElse(10);
        var queryOrder = orderUf.orElse(QueryOrder.Desc);
        var varordermunicipio = orderMunicipio.orElse(QueryOrder.Desc);
        var varorderSchoolName = orderBySchoolName.orElse(QueryOrder.Desc);

        var query = new InseQueryIn(pageN,
                perPageContent,
                uf,
                queryOrder,
                municipio,
                varordermunicipio,
                querySchoolName,
                varorderSchoolName);
        return InseService.QueryInse(query);
    }

    @GetMapping("by-state/{id}")
    public InseAggregationOut AvgByState(@PathVariable Long id) {
        return InseService.AvgByState(id);
    }

    @GetMapping("by-city-type/{tipoCapital}")
    public InseAggregationOut AvgCityType(@PathVariable TipoCapital tipoCapital) {
        return InseService.AvgByCityType(tipoCapital);
    }

    @GetMapping("by-city/{id}")
    public InseAggregationOut AvgByCity(@PathVariable Long id) {
        return InseService.AvgByCity(id);
    }

    @GetMapping("by-location-type/{tipoLocalizacao}")
    public InseAggregationOut AvgByLocationType(@PathVariable TipoLocalizacao tipoLocalizacao) {
        return InseService.AvgByLocationType(tipoLocalizacao);
    }

    @GetMapping("by-network-type/{tipoRede}")
    public InseAggregationOut AvgByNetworkType(@PathVariable TipoRede tipoRede) {
        return InseService.AvgByNetworkType(tipoRede);
    }
}
