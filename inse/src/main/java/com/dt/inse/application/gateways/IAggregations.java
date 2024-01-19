package com.dt.inse.application.gateways;

import com.dt.inse.application.DTO.aggregation.InseAggregationOut;

import java.util.Map;

public interface IAggregations {

    InseAggregationOut AvgAggregate(Map<String, Long> fields);
}
