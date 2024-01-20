package com.dt.inse.application.DTO;

import com.dt.inse.application.DTO.aggregation.InseAggregationOut;
import com.dt.inse.domain.model.Inse;
import com.dt.inse.domain.pagination.Pagination;

public record InseQueryOut(
        Pagination<Inse> pagination,
        InseAggregationOut aggregationOut
) {
}
