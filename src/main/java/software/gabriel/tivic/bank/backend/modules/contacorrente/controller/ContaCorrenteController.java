/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import software.gabriel.tivic.bank.backend.modules.contacorrente.dto.ContaCorrenteDTO;
import software.gabriel.tivic.bank.backend.modules.contacorrente.service.VisualizarContaCorrenteTerceirosService;
import software.gabriel.tivic.bank.backend.modules.contacorrente.service.VisualizarPropriaContaCorrenteService;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.OperacaoDTO;

/**
 *
 * @author gabriel
 */
@RestController
public class ContaCorrenteController {

    @Autowired
    VisualizarPropriaContaCorrenteService visualizarPropriaContaCorrenteService;
    
    @Autowired
    VisualizarContaCorrenteTerceirosService visualizarContaCorrenteTerceirosService;

    @GetMapping("/conta")
    public ResponseEntity<ContaCorrenteDTO> visualizarDados() {
        return ResponseEntity.ok(visualizarPropriaContaCorrenteService.visualizarDados());
    }

    @GetMapping("/conta/operacoes")
    public ResponseEntity<Page<OperacaoDTO>> visualizarOperacoes(@PageableDefault(value = 10) Pageable page) {
        return ResponseEntity.ok(visualizarPropriaContaCorrenteService.visualizarOperacoes(page));
    }
    
    @GetMapping("/contas/{id}")
    public ResponseEntity<ContaCorrenteDTO> visualizar(@PathVariable Long id) {
        return ResponseEntity.ok(visualizarContaCorrenteTerceirosService.visualizar(id));
    }
    

}
