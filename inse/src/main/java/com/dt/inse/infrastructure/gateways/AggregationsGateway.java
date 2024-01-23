package com.dt.inse.infrastructure.gateways;

import com.dt.inse.application.DTO.aggregation.InseAggregationOut;
import com.dt.inse.application.gateways.IAggregations;
import com.dt.inse.infrastructure.JpaEntities.InseJpaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.dt.inse.infrastructure.gateways.commom.AggregationUtils.getAggregationOut;

@Repository
public class AggregationsGateway implements IAggregations {
    private static final String[] VALID_KEYS =
            {"codUF",
                    "CodMunicipio",
                    "tipoRede",
                    "tipoLocalizacao",
                    "tipoCapital",
                    "mediaInse"
            };

    @PersistenceContext
    private EntityManager entityManager;

    public InseAggregationOut AvgAggregate(Map<String, Long> fields) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<InseJpaEntity> root = query.from(InseJpaEntity.class);

        List<Predicate> predicateList = new ArrayList<>();
        for (String s : fields.keySet()) {
            if (Arrays.stream(VALID_KEYS).toList().contains(s)) {
                Long code = fields.get(s);
                predicateList.add(cb.equal(root.get(s), code));
            }
        }
        query.where(predicateList.toArray(new Predicate[0]));

        return getAggregationOut(cb, query, root, entityManager);
    }
}
