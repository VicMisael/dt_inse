package com.dt.inse.domain.model;

import com.dt.inse.domain.enumerations.TipoCapital;
import com.dt.inse.domain.enumerations.TipoLocalizacao;
import com.dt.inse.domain.enumerations.TipoRede;

import java.math.BigDecimal;

public record Inse(
        String AnoSaeb,
        Long CodUF,
        String NomeUF,
        Long CodMunicipio,
        String NomeMunicipio,
        Long IdEscola,
        String NomeEscola,
        TipoRede tipoRede,
        TipoLocalizacao tipoLocalizacao,
        TipoCapital tipoCapital,
        Long QtdAlunos,
        BigDecimal MediaInse,
        String InseClassificacao,
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
