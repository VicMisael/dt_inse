package com.dt.inse.application.DTO;

import com.dt.inse.commons.QueryOrder;

import java.util.Optional;

public record InseQueryIn(
        int Page,
        int PerPage,
        QueryOrder orderMediaInse,
        Optional<String> Uf,
        QueryOrder OrderUf,
        Optional<String> Municipio,
        QueryOrder OrderMunicipio,
        Optional<String> QuerySchoolName,
        QueryOrder OrderBySchoolName
) {
}
