/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrente;
import software.gabriel.tivic.bank.backend.modules.contacorrente.exception.ContaNaoEncontradaException;
import software.gabriel.tivic.bank.backend.modules.contacorrente.repository.ContaCorrenteRepository;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.TransferenciaDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Transferencia;
import software.gabriel.tivic.bank.backend.modules.operacao.exception.TransferenciaPropriaContaException;
import software.gabriel.tivic.bank.backend.modules.operacao.mapper.OperacaoMapper;
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
    OperacaoMapper operacaoMapper;

    public void transferir(TransferenciaDTO transferenciaDTO) {
        Transferencia transferencia = operacaoMapper.toTransferenciaEntity(transferenciaDTO);
        ContaCorrente contaOrigem = contaCorrenteRepository.findByCliente(SecurityUtils.getClienteAutenticado());
        transferencia.setContaDestino(validarContaDestino(transferencia.getContaDestino(), contaOrigem));
        OperacaoUtils.validarOperacaoSaida(transferencia.getValor(), contaOrigem.getSaldo());
        transferencia.setContaOrigem(contaOrigem);
        contaOrigem.subtrairSaldo(transferencia.getValor());
        transferencia.getContaDestino().adicionarSaldo(transferencia.getValor());
        transferencia.setMomento(LocalDateTime.now());
        operacaoRepository.save(transferencia);
    }

    private ContaCorrente validarContaDestino(ContaCorrente contaDestino, ContaCorrente contaOrigem) {
        contaDestino = contaCorrenteRepository.findById(contaDestino.getId()).orElseThrow(ContaNaoEncontradaException::new);
        if (contaDestino.equals(contaOrigem)) {
            throw new TransferenciaPropriaContaException();
        }
        return contaDestino;
    }

}
