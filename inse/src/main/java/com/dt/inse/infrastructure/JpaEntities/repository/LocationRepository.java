package com.dt.inse.infrastructure.JpaEntities.repository;

import com.dt.inse.domain.model.location.City;
import com.dt.inse.domain.model.location.UF;
import com.dt.inse.infrastructure.JpaEntities.InseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<InseJpaEntity,Long> {
    @Query("SELECT DISTINCT new com.dt.inse.domain.model.location.UF(e.nomeUf, e.codUF) FROM InseJpaEntity e")
    List<UF> findDistinctUF();

    @Query("SELECT DISTINCT new com.dt.inse.domain.model.location.City(e.nomeMunicipio, e.codMunicipio) FROM InseJpaEntity e where e.codUF=?1")
    List<City> findDistinctCityByCodUF(Long ufid);
}
