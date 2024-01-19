package com.dt.inse.application.DTO;

import com.dt.inse.commons.QueryOrder;

import java.util.Optional;

public record InseQueryIn(
        int Page,
        int PerPage,
        Optional<String> Uf,
        QueryOrder OrderUf,
        Optional<String> Municipio,
        QueryOrder OrderMunicipio,
        String QuerySchoolName,
        QueryOrder OrderBySchoolName


) {
}
