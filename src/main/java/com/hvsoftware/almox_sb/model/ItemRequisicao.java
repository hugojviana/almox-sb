package com.hvsoftware.almox_sb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "itemrequisicao")
public class ItemRequisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "requisicao_id")
    private Requisicao requisicao;
    private Double quantidade;

    public ItemRequisicao(Produto produto, Requisicao requisicao, Double quantidade) {
        this.produto = produto;
        this.requisicao = requisicao;
        this.quantidade = quantidade;
    }

    public ItemRequisicao(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
