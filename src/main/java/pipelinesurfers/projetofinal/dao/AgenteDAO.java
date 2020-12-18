package pipelinesurfers.projetofinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pipelinesurfers.projetofinal.model.AgenteFinanceiro;

public interface AgenteDAO extends CrudRepository<AgenteFinanceiro, Integer> {
    public List<AgenteFinanceiro> findTop10ByOrderByVolumeTransacionalDesc();
   
/*     @Query(value = "Select nome_agente,volume_transacional from mtb310_ag_financeiro order by volume_transacional desc", nativeQuery = true)
    public Object findTop10ByOrderByVolumeTransacionalDesc(@Param("cod") Integer codigo);  */

}