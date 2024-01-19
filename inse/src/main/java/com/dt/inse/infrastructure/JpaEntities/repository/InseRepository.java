package com.dt.inse.infrastructure.JpaEntities.repository;

import com.dt.inse.infrastructure.JpaEntities.InseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InseRepository extends JpaRepository<InseJpaEntity, Long>, PagingAndSortingRepository<InseJpaEntity, Long> {
}
