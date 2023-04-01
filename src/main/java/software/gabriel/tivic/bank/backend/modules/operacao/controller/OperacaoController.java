/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.DepositoDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.SaqueDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.TransferenciaDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.service.RealizarDepositoService;
import software.gabriel.tivic.bank.backend.modules.operacao.service.RealizarSaqueService;
import software.gabriel.tivic.bank.backend.modules.operacao.service.RealizarTransferenciaService;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/operacoes")
public class OperacaoController {

    @Autowired
    RealizarDepositoService realizarDepositoService;
    
    @Autowired
    RealizarSaqueService realizarSaqueService;
    
    @Autowired
    RealizarTransferenciaService realizarTransferenciaService;

    @PostMapping("/depositos")
    public ResponseEntity<Void> depositar(@RequestBody @Valid DepositoDTO depositoDTO) {
        realizarDepositoService.depositar(depositoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/saques")
    public ResponseEntity<Void> sacar(@RequestBody @Valid SaqueDTO saqueDTO) {
        realizarSaqueService.sacar(saqueDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/transferencias")
    public ResponseEntity<Void> transferir(@RequestBody @Valid TransferenciaDTO transferenciaDTO) {        
        realizarTransferenciaService.transferir(transferenciaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
