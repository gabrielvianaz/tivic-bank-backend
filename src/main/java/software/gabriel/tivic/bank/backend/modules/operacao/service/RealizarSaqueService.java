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
import software.gabriel.tivic.bank.backend.modules.operacao.dto.SaqueDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Saque;
import software.gabriel.tivic.bank.backend.modules.operacao.mapper.SaqueMapper;
import software.gabriel.tivic.bank.backend.modules.operacao.repository.OperacaoRepository;
import software.gabriel.tivic.bank.backend.modules.operacao.util.OperacaoUtils;
import software.gabriel.tivic.bank.backend.modules.security.util.SecurityUtils;

/**
 *
 * @author gabriel
 */
@Service
public class RealizarSaqueService {

    @Autowired
    OperacaoRepository operacaoRepository;

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    SaqueMapper saqueMapper;

    public void sacar(SaqueDTO saqueDTO) {
        ContaCorrente contaOrigem = contaCorrenteRepository.findByCliente(SecurityUtils.getClienteAutenticado());
        OperacaoUtils.validarOperacaoSaida(saqueDTO.getValor(), contaOrigem.getSaldo());
        Saque saque = saqueMapper.toEntity(saqueDTO);
        saque.setContaOrigem(contaOrigem);
        contaOrigem.subtrairSaldo(saque.getValor());
        saque.setMomento(LocalDateTime.now());
        operacaoRepository.save(saque);
    }

}
