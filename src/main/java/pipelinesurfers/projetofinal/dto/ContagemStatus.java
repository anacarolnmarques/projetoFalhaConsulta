package pipelinesurfers.projetofinal.dto;

import lombok.Getter;

@Getter
public class ContagemStatus {
    private String agente;
    private int status;
    private long count;

    public ContagemStatus(String agente, int status, long count) {
        this.agente = agente;
        this.status = status;
        this.count = count;
}
}
