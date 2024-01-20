package com.dt.inse.infrastructure.gateways;

import com.dt.inse.application.DTO.InseQueryIn;
import com.dt.inse.application.DTO.InseQueryOut;
import com.dt.inse.application.DTO.aggregation.InseAggregationOut;
import com.dt.inse.application.gateways.IPagedQuery;
import com.dt.inse.commons.QueryOrder;
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

import static com.dt.inse.infrastructure.gateways.commom.AggregationUtils.getAggregationOut;

@Repository
public class PagedQuery implements IPagedQuery {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public InseQueryOut QueryInse(InseQueryIn in) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<InseJpaEntity> query = cb.createQuery(InseJpaEntity.class);
        Root<InseJpaEntity> inseRoot = query.from(InseJpaEntity.class);


        List<Predicate> predicates = getPredicates(in, cb, inseRoot);
        ArrayList<Order> orderList = getOrders(in, cb, inseRoot);
        //Salva uma cópia

        query.where(predicates.toArray(new Predicate[0]));
        query.orderBy(orderList);

        TypedQuery<InseJpaEntity> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult((in.Page() - 1) * in.PerPage());
        typedQuery.setMaxResults(in.PerPage());
        List<InseJpaEntity> results = typedQuery.getResultList();

        // Count Query setup
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<InseJpaEntity> countRoot = countQuery.from(InseJpaEntity.class); // New root for count query

        countQuery.select(cb.count(countRoot));
        countQuery.where(cb.and(getPredicates(in, cb, countRoot).toArray(new Predicate[0]))); // Apply same predicates to count query

        TypedQuery<Long> countTypedQuery = entityManager.createQuery(countQuery);
        long total = countTypedQuery.getSingleResult();


        var pagination = new Pagination<>(in.Page(), (int) total, in.PerPage(), results.stream().map(InseJpaToInseDomain::mapToInse).toList());

        return new InseQueryOut(pagination, aggregationOut(cb, in));
    }

    private InseAggregationOut aggregationOut(CriteriaBuilder cb, InseQueryIn in) {

        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<InseJpaEntity> root = query.from(InseJpaEntity.class);
        query.where(getPredicates(in, cb, root).toArray(new Predicate[0]));

        return getAggregationOut(cb, query, root, entityManager);
    }


    private static ArrayList<Order> getOrders(InseQueryIn in, CriteriaBuilder cb, Root<InseJpaEntity> inse) {
        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(in.orderMediaInse() == QueryOrder.Asc ? cb.asc(inse.get("mediaInse")) : cb.desc(inse.get("mediaInse")));
        orderList.add(in.OrderUf() == QueryOrder.Asc ? cb.asc(inse.get("nomeUf")) : cb.desc(inse.get("nomeUf")));
        orderList.add(in.OrderBySchoolName() == QueryOrder.Asc ? cb.asc(inse.get("nomeEscola")) : cb.desc(inse.get("nomeEscola")));
        orderList.add(in.OrderMunicipio() == QueryOrder.Asc ? cb.asc(inse.get("nomeMunicipio")) : cb.desc(inse.get("nomeMunicipio")));
        return orderList;
    }

    private static List<Predicate> getPredicates(InseQueryIn in, CriteriaBuilder cb, Root<InseJpaEntity> inse) {
        List<Predicate> predicates = new ArrayList<>();

        in.Municipio().ifPresent(nomeMunicipio -> predicates.add(cb.like(cb.lower(inse.get("nomeMunicipio")), "%" + nomeMunicipio.toLowerCase() + "%")));
        in.QuerySchoolName().ifPresent(schoolName -> predicates.add(cb.like(cb.lower(inse.get("nomeEscola")), "%" + schoolName.toLowerCase() + "%")));
        in.Uf().ifPresent(uf -> predicates.add(cb.like(cb.lower(inse.get("nomeUf")), "%" + uf.toLowerCase() + "%")));
        return predicates;
    }
}
