package com.dt.inse.infrastructure.gateways;

import com.dt.inse.application.DTO.InseQueryIn;
import com.dt.inse.application.gateways.IPagedQuery;
import com.dt.inse.commons.QueryOrder;
import com.dt.inse.domain.model.Inse;
import com.dt.inse.domain.pagination.Pagination;
import com.dt.inse.infrastructure.JpaEntities.InseJpaEntity;
import com.dt.inse.infrastructure.JpaEntities.mappers.InseJpaToInseDomain;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PagedQuery implements IPagedQuery {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pagination<Inse> QueryInse(InseQueryIn in) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<InseJpaEntity> query = cb.createQuery(InseJpaEntity.class);
        Root<InseJpaEntity> inse = query.from(InseJpaEntity.class);





        List<Predicate> predicates = new ArrayList<>();

        in.Municipio().ifPresent(nomeMunicipio -> predicates.add(cb.like(cb.lower(inse.get("nomeMunicipio")), "%" + nomeMunicipio.toLowerCase() + "%")));
        in.QuerySchoolName().ifPresent(schoolName -> predicates.add(cb.like(cb.lower(inse.get("nomeEscola")), "%" + schoolName.toLowerCase() + "%")));
        in.Uf().ifPresent(uf -> predicates.add(cb.like(cb.lower(inse.get("nomeUf")), "%" + uf.toLowerCase() + "%")));

        query.where(predicates.toArray(new Predicate[0]));

        List<Order> orderList = new ArrayList<>();
        orderList.add(in.OrderUf() == QueryOrder.Asc ? cb.asc(inse.get("nomeUf")) : cb.desc(inse.get("nomeUf")));
        orderList.add(in.OrderBySchoolName() == QueryOrder.Asc ? cb.asc(inse.get("nomeEscola")) : cb.desc(inse.get("nomeEscola")));
        orderList.add(in.OrderMunicipio() == QueryOrder.Asc ? cb.asc(inse.get("nomeMunicipio")) : cb.desc(inse.get("nomeMunicipio")));

        query.orderBy(orderList);
        // Execute Query for Count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        countQuery.select(cb.count(countQuery.from(InseJpaEntity.class)));
        // Apply the same predicates to count query
        long total = entityManager.createQuery(countQuery).getSingleResult();

        TypedQuery<InseJpaEntity> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult((in.Page() - 1) * in.PerPage());
        typedQuery.setMaxResults(in.PerPage());
        List<InseJpaEntity> results = typedQuery.getResultList();

        return new Pagination<>(in.Page(), (int) total, in.PerPage(), results.stream().map(InseJpaToInseDomain::mapToInse).toList());
    }
}
