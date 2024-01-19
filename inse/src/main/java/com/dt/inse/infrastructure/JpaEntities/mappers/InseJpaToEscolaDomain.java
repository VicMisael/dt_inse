package com.dt.inse.infrastructure.JpaEntities.mappers;

import com.dt.inse.domain.enumerations.TipoCapital;
import com.dt.inse.domain.enumerations.TipoLocalizacao;
import com.dt.inse.domain.enumerations.TipoRede;
import com.dt.inse.domain.model.Escola;
import com.dt.inse.infrastructure.JpaEntities.InseJpaEntity;

public class InseJpaToEscolaDomain {
    public static Escola mapToInse(InseJpaEntity entity) {
        return new Escola(
                entity.getIdEscola(),
                entity.getNomeEscola(),
                TipoRede.fromInteger(entity.getTipoRede()),
                TipoLocalizacao.fromInteger(entity.getTipoLocalizacao()),
                TipoCapital.fromInteger(entity.getTipoCapital()),
                entity.getQtdAlunos(),
                entity.getMediaInse(),
                entity.getInseClassificacao(),
                entity.getPorcentagemNivel1(),
                entity.getPorcentagemNivel2(),
                entity.getPorcentagemNivel3(),
                entity.getPorcentagemNivel4(),
                entity.getPorcentagemNivel5(),
                entity.getPorcentagemNivel6(),
                entity.getPorcentagemNivel7(),
                entity.getPorcentagemNivel8()
        );
    }

}
