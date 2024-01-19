package com.dt.inse.application.DTO.aggregation;

import java.math.BigDecimal;

public record InseAggregationOut(
        BigDecimal QtdAlunos,
        BigDecimal MediaInse,
        BigDecimal PorcentagemNivel1,
        BigDecimal PorcentagemNivel2,
        BigDecimal PorcentagemNivel3,
        BigDecimal PorcentagemNivel4,
        BigDecimal PorcentagemNivel5,
        BigDecimal PorcentagemNivel6,
        BigDecimal PorcentagemNivel7,
        BigDecimal PorcentagemNivel8
) {
}
