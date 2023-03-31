/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.gabriel.tivic.bank.backend.modules.cliente.dto.ClientePessoaFisicaDTO;
import software.gabriel.tivic.bank.backend.modules.cliente.dto.ClientePessoaJuridicaDTO;
import software.gabriel.tivic.bank.backend.modules.cliente.service.CadastrarClienteService;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    CadastrarClienteService cadastrarClienteService;
    
    @PostMapping("/pf")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ClientePessoaFisicaDTO clientePessoaFisicaDTO) {                
        cadastrarClienteService.cadastrar(clientePessoaFisicaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();        
    }
    
    @PostMapping("/pj")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ClientePessoaJuridicaDTO clientePessoaJuridicaDTO) {        
        cadastrarClienteService.cadastrar(clientePessoaJuridicaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();        
    }
    
}
