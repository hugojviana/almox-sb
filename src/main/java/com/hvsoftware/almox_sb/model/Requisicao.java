package model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "requisicao")
public class Requisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "requisicao", cascade = CascadeType.ALL)
    private List<ItemRequisicao> itens;

    private LocalDateTime dataHora;
    private String setorRequisitante;
    private String responsavelRequisitante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemRequisicao> getItens() {
        return itens;
    }

    public void setItens(List<ItemRequisicao> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getSetorRequisitante() {
        return setorRequisitante;
    }

    public void setSetorRequisitante(String setorRequisitante) {
        this.setorRequisitante = setorRequisitante;
    }

    public String getResponsavelRequisitante() {
        return responsavelRequisitante;
    }

    public void setResponsavelRequisitante(String responsavelRequisitante) {
        this.responsavelRequisitante = responsavelRequisitante;
    }
}
