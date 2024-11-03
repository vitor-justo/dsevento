package com.devsuperior.dsevento.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "atividade")
    private List<Bloco> bloco = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tb_atividade_participante",
            joinColumns = @JoinColumn(name = "atividade_id"),
            inverseJoinColumns = @JoinColumn(name = "participante_id"))
    private Set<Participante> participante = new HashSet<>();

    public Atividade() {
    }

    public Atividade(Integer id, String nome, String descricao, Double preco, Set<Participante> participante) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.participante = participante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Bloco> getBloco() {
        return bloco;
    }

    public Set<Participante> getParticipante() {
        return participante;
    }

    public void setParticipante(Set<Participante> participante) {
        this.participante = participante;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
