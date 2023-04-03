/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import software.gabriel.tivic.bank.backend.modules.contacorrente.dto.ContaCorrenteDTO;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrente;
import software.gabriel.tivic.bank.backend.modules.contacorrente.mapper.ContaCorrenteMapper;
import software.gabriel.tivic.bank.backend.modules.contacorrente.repository.ContaCorrenteRepository;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.OperacaoDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Operacao;
import software.gabriel.tivic.bank.backend.modules.operacao.mapper.OperacaoMapper;
import software.gabriel.tivic.bank.backend.modules.operacao.repository.OperacaoRepository;
import software.gabriel.tivic.bank.backend.modules.security.util.SecurityUtils;

/**
 *
 * @author gabriel
 */
@Service
public class VisualizarPropriaContaCorrenteService {

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;
    
    @Autowired
    OperacaoRepository operacaoRepository;

    @Autowired
    ContaCorrenteMapper contaCorrenteMapper;

    @Autowired
    OperacaoMapper operacaoMapper;

    public ContaCorrenteDTO visualizarDados() {
        ContaCorrente contaCorrente = contaCorrenteRepository.findByCliente(SecurityUtils.getClienteAutenticado());

        return contaCorrenteMapper.toDTO(contaCorrente);
    }

    public Page<OperacaoDTO> visualizarOperacoes(Pageable page) {
        ContaCorrente contaCorrente = contaCorrenteRepository.findByCliente(SecurityUtils.getClienteAutenticado());
        Page<Operacao> operacoes = operacaoRepository.findByContaOrigemOrContaDestinoOrderById(contaCorrente, contaCorrente, page);
        
        return operacoes.map(operacao -> operacaoMapper.toDto(operacao));
    }

}
