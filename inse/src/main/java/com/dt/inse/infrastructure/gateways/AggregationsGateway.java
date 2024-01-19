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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
public class AggregationsGateway implements IAggregations {
    private static final String[] VALID_KEYS =
            {"CodUF",
                    "CodMunicipio",
                    "tipoRede",
                    "tipoLocalizacao",
                    "tipoCapital",
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
                var code = fields.get(s);
                predicateList.add(cb.equal(root.get(s), code));
            }
        }
        query.where(predicateList.toArray(predicateList.toArray(new Predicate[0])));

        query.multiselect(
                cb.avg(root.get("qtdAlunos").as(BigDecimal.class)),
                cb.avg(root.get("mediaInse").as(BigDecimal.class)),
                cb.avg(root.get("porcentagemNivel1").as(BigDecimal.class)),
                cb.avg(root.get("porcentagemNivel2").as(BigDecimal.class)),
                cb.avg(root.get("porcentagemNivel3").as(BigDecimal.class)),
                cb.avg(root.get("porcentagemNivel4").as(BigDecimal.class)),
                cb.avg(root.get("porcentagemNivel5").as(BigDecimal.class)),
                cb.avg(root.get("porcentagemNivel6").as(BigDecimal.class)),
                cb.avg(root.get("porcentagemNivel7").as(BigDecimal.class)),
                cb.avg(root.get("porcentagemNivel8").as(BigDecimal.class))
        );

        Object[] results = entityManager.createQuery(query).getSingleResult();
        if (results[0] == null) {
            return null;
        }
        return new InseAggregationOut(
                BigDecimal.valueOf((Double) results[0]),
                BigDecimal.valueOf((Double) results[1]),
                BigDecimal.valueOf((Double) results[2]),
                BigDecimal.valueOf((Double) results[3]),
                BigDecimal.valueOf((Double) results[4]),
                BigDecimal.valueOf((Double) results[5]),
                BigDecimal.valueOf((Double) results[6]),
                BigDecimal.valueOf((Double) results[7]),
                BigDecimal.valueOf((Double) results[8]),
                BigDecimal.valueOf((Double) results[9])
        );
    }
}
