/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrente;
import software.gabriel.tivic.bank.backend.modules.contacorrente.exception.ContaDestinoNaoEncontradaException;
import software.gabriel.tivic.bank.backend.modules.contacorrente.repository.ContaCorrenteRepository;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.TransferenciaDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Transferencia;
import software.gabriel.tivic.bank.backend.modules.operacao.mapper.TransferenciaMapper;
import software.gabriel.tivic.bank.backend.modules.operacao.repository.OperacaoRepository;
import software.gabriel.tivic.bank.backend.modules.operacao.util.OperacaoUtils;
import software.gabriel.tivic.bank.backend.modules.security.util.SecurityUtils;

/**
 *
 * @author gabriel
 */
@Service
public class RealizarTransferenciaService {

    @Autowired
    OperacaoRepository operacaoRepository;

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    TransferenciaMapper transferenciaMapper;

    public void transferir(TransferenciaDTO transferenciaDTO) {
        Transferencia transferencia = transferenciaMapper.toEntity(transferenciaDTO);
        validarContaDestino(transferencia.getContaDestino());
        ContaCorrente contaOrigem = contaCorrenteRepository.findByCliente(SecurityUtils.getClienteAutenticado());        
        OperacaoUtils.validarOperacaoSaida(transferencia.getValor(), contaOrigem.getSaldo());        
        ContaCorrente contaDestino = contaCorrenteRepository.findById(transferencia.getContaDestino().getId()).get();
        transferencia.setContaDestino(contaDestino);
        transferencia.setContaOrigem(contaOrigem);
        contaOrigem.subtrairSaldo(transferencia.getValor());
        transferencia.getContaDestino().adicionarSaldo(transferencia.getValor());
        transferencia.setMomento(LocalDateTime.now());
        operacaoRepository.save(transferencia);
    }

    private void validarContaDestino(ContaCorrente contaDestino) {
        contaCorrenteRepository.findById(contaDestino.getId()).orElseThrow(ContaDestinoNaoEncontradaException::new);
    }

}
