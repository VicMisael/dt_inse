package com.dt.inse.infrastructure.JpaEntities.repository;

import com.dt.inse.domain.model.location.City;
import com.dt.inse.domain.model.location.UF;
import com.dt.inse.infrastructure.JpaEntities.InseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InseRepository extends JpaRepository<InseJpaEntity, Long> {
    InseJpaEntity findByIdEscola(Long IdEscola);
    boolean existsByIdEscola(Long IdEscola);


}
