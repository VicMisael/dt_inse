package com.dt.inse.infrastructure.gateways.commom;

import com.dt.inse.application.DTO.aggregation.InseAggregationOut;
import com.dt.inse.infrastructure.JpaEntities.InseJpaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.math.BigDecimal;

public class AggregationUtils {
    public static InseAggregationOut getAggregationOut(CriteriaBuilder cb, CriteriaQuery<Object[]> query, Root<InseJpaEntity> root, EntityManager entityManager) {
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
