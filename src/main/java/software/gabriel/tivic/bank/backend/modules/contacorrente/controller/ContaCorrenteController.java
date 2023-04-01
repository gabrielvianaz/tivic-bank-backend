/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.gabriel.tivic.bank.backend.modules.contacorrente.dto.ContaCorrenteDTO;
import software.gabriel.tivic.bank.backend.modules.contacorrente.service.VisualizarContaCorrenteService;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.OperacaoDTO;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/contas")
public class ContaCorrenteController {

    @Autowired
    VisualizarContaCorrenteService visualizarDadosContaCorrenteService;

    @GetMapping
    public ResponseEntity<ContaCorrenteDTO> visualizarDados() {
        return ResponseEntity.ok(visualizarDadosContaCorrenteService.visualizarDados());
    }
    
    @GetMapping("/operacoes")
    public ResponseEntity<List<OperacaoDTO>> visualizarOperacoes() {
        return ResponseEntity.ok(visualizarDadosContaCorrenteService.visualizarOperacoes());
    }

}
