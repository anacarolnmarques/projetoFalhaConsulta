package pipelinesurfers.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pipelinesurfers.projetofinal.dao.AgenteDAO;
import pipelinesurfers.projetofinal.model.AgenteFinanceiro;

@RestController
@CrossOrigin("*")
@RequestMapping("/agentes")
public class AgenteController {

    @Autowired // Injecao de dependencia
    private AgenteDAO dao;

    @GetMapping("/all")
    public List<AgenteFinanceiro> listarTodos() {
        List<AgenteFinanceiro> lista = (List<AgenteFinanceiro>) dao.findTop10ByOrderByVolumeTransacionalDesc();
        return lista;
    } 

    
    
}
