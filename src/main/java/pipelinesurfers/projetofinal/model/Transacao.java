package pipelinesurfers.projetofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mtb310_transaction")
@Getter @Setter @NoArgsConstructor
public class Transacao {

    @Id // Indica chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 1,2,3
    @Column(name = "id_transacao")
    private int idTransacao;

    @Column(name = "data_hora")
    private String dataHora;

    @Column(name = "dispositivo")
    private int dispositivo;

    @Column(name = "valor_solic")
    private double  valorSolic;

    @Column(name = "valor_aut")
    private double valorAut;

    @Column(name = "status")
    private int status;

    

    @ManyToOne
    @JoinColumn(name = "ag_financeiro")
    @JsonIgnoreProperties("transacoes")
    private AgenteFinanceiro agente; 
}
