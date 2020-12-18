package pipelinesurfers.projetofinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pipelinesurfers.projetofinal.dto.ContagemStatus;
import pipelinesurfers.projetofinal.model.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer>{
    public Transacao findByStatus(int status);

    @Query("SELECT new pipelinesurfers.projetoFinal.dto.ContagemStatus(t.agente.nomeAgente, t.status, COUNT(t.status)) FROM Transacao AS t WHERE t.agente.idAgente = ?1 GROUP BY t.agente.nomeAgente, t.status ORDER By t.status")
    List<ContagemStatus> countStatusByAgent(int idAgente);
}
