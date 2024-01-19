package com.dt.inse.infrastructure.JpaEntities;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "inse")
@Getter
public class InseJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "NU_ANO_SAEB")
    String AnoSaeb;

    @Column(name = "CO_UF")
    Long CodUF;

    @Column(name = "SG_UF")
    String NomeUF;

    @Column(name = "CO_MUNICIPIO")
    Long CodMunicipio;

    @Column(name = "ID_ESCOLA")
    Long IdEscola;

    @Column(name = "NO_ESCOLA")
    String NomeEscola;

    @Column(name = "TP_TIPO_REDE")
    Integer tipoRede;
    @Column(name = "TP_LOCALIZACAO")
    Integer tipoLocalizacao;

    @Column(name = "TP_CAPITAL")
    Integer tipoCapital;

    @Column(name = "QTD_ALUNOS_INSE")
    Long QtdAlunos;

    @Column(name = "MEDIA_INSE")
    BigDecimal MediaInse;

    @Column(name = "INSE_CLASSIFICACAO")
    String InseClassificacao;

    @Column(name = "PC_NIVEL_1")
    BigDecimal PorcentagemNivel1;

    @Column(name = "PC_NIVEL_2")
    BigDecimal PorcentagemNivel2;

    @Column(name = "PC_NIVEL_3")
    BigDecimal PorcentagemNivel3;

    @Column(name = "PC_NIVEL_4")
    BigDecimal PorcentagemNivel4;

    @Column(name = "PC_NIVEL_5")
    BigDecimal PorcentagemNivel5;

    @Column(name = "PC_NIVEL_6")
    BigDecimal PorcentagemNivel6;

    @Column(name = "PC_NIVEL_7")
    BigDecimal PorcentagemNivel7;

    @Column(name = "PC_NIVEL_8")
    BigDecimal PorcentagemNivel8;
}

