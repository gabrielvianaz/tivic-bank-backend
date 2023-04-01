/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrente;
import software.gabriel.tivic.bank.backend.modules.contacorrente.repository.ContaCorrenteRepository;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.DepositoDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Deposito;
import software.gabriel.tivic.bank.backend.modules.operacao.mapper.DepositoMapper;
import software.gabriel.tivic.bank.backend.modules.operacao.repository.OperacaoRepository;
import software.gabriel.tivic.bank.backend.modules.security.util.SecurityUtils;

/**
 *
 * @author gabriel
 */
@Service
public class RealizarDepositoService {
    
    @Autowired
    OperacaoRepository operacaoRepository;
    
    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;
    
    @Autowired
    DepositoMapper depositoMapper;
    
    public void depositar(DepositoDTO depositoDTO) {        
        Deposito deposito = depositoMapper.toEntity(depositoDTO);
        ContaCorrente contaDestino = contaCorrenteRepository.findByCliente(SecurityUtils.getClienteAutenticado());
        deposito.setContaDestino(contaDestino);
        contaDestino.adicionarSaldo(deposito.getValor());
        deposito.setMomento(LocalDateTime.now());
        operacaoRepository.save(deposito);        
    }
    
}
