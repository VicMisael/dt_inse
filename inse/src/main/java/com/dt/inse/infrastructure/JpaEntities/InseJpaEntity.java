package com.dt.inse.infrastructure.JpaEntities;


import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(name = "inse")
@Getter
public class InseJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NU_ANO_SAEB")
    String anoSaeb;

    @Column(name = "CO_UF")
    Long codUF;

    @Column(name = "SG_UF")
    String siglaUF;

    @Column(name = "NO_UF")
    String nomeUf;

    @Column(name = "CO_MUNICIPIO")
    Long codMunicipio;

    @Column(name = "NO_MUNICIPIO")
    String nomeMunicipio;

    @Column(name = "ID_ESCOLA")
    Long idEscola;

    @Column(name = "NO_ESCOLA")
    String nomeEscola;

    @Column(name = "TP_TIPO_REDE")
    Integer tipoRede;
    @Column(name = "TP_LOCALIZACAO")
    Integer tipoLocalizacao;

    @Column(name = "TP_CAPITAL")
    Integer tipoCapital;

    @Column(name = "QTD_ALUNOS_INSE")
    Long qtdAlunos;

    @Column(name = "MEDIA_INSE")
    BigDecimal mediaInse;

    @Column(name = "INSE_CLASSIFICACAO")
    String inseClassificacao;

    @Column(name = "PC_NIVEL_1")
    BigDecimal porcentagemNivel1;

    @Column(name = "PC_NIVEL_2")
    BigDecimal porcentagemNivel2;

    @Column(name = "PC_NIVEL_3")
    BigDecimal porcentagemNivel3;

    @Column(name = "PC_NIVEL_4")
    BigDecimal porcentagemNivel4;

    @Column(name = "PC_NIVEL_5")
    BigDecimal porcentagemNivel5;

    @Column(name = "PC_NIVEL_6")
    BigDecimal porcentagemNivel6;

    @Column(name = "PC_NIVEL_7")
    BigDecimal porcentagemNivel7;

    @Column(name = "PC_NIVEL_8")
    BigDecimal porcentagemNivel8;
}

