package pipelinesurfers.projetofinal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mtb310_ag_financeiro")
@Getter @Setter @NoArgsConstructor
public class AgenteFinanceiro {

    @Id // Indica chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 1,2,3
    @Column(name = "id_agente", insertable = false, updatable = false)
    private int idAgente;

    @Column(name = "nome_agente", length = 100, nullable = false)
    private String nomeAgente;

    @Column(name = "volume_transacional")
    private double volumeTransacional;

    public AgenteFinanceiro(String nomeAgente, double volumeTransacional) {
        this.nomeAgente = nomeAgente;
        this.volumeTransacional = volumeTransacional;
    }

    @OneToMany (mappedBy = "agente")
    @JsonIgnoreProperties("agente")
    private List<Transacao> transacoes;

}