package com.gleice.funcionario.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
public class Projeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projeto_generator")
    private Long id;

    @Column(length = 100, nullable = false)
    private String titulo;
  
    @Column(length = 250, nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataFim;

    @Column(columnDefinition = "Decimal(10,2)", nullable = false)
    private double valorPrevisto;

    @Column(columnDefinition = "Decimal(10,2)", nullable = false)
    private double valorGasto;

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    },
        mappedBy = "projetos")
    @JsonIgnore
    private Set<Funcionario> funcionarios = new HashSet<>();

}

