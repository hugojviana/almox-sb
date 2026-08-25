package com.hvsoftware.almox_sb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double quantidade;
    private Double quantidadeMinima;
    private Double preco;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String unidadeDeMedida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Double quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "ID=" + id +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", quantidadeMinima=" + quantidadeMinima +
                ", preço=" + preco +
                ", categoria='" + categoria + '\'' +
                ", unidadeDeMedida='" + unidadeDeMedida + '\'' +
                '}';
    }
}
