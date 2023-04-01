/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.tivic.bank.backend.modules.contacorrente.dto.ContaCorrenteDTO;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrente;
import software.gabriel.tivic.bank.backend.modules.contacorrente.mapper.ContaCorrenteMapper;
import software.gabriel.tivic.bank.backend.modules.contacorrente.repository.ContaCorrenteRepository;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.OperacaoDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.mapper.OperacaoMapper;
import software.gabriel.tivic.bank.backend.modules.security.util.SecurityUtils;

/**
 *
 * @author gabriel
 */
@Service
public class VisualizarContaCorrenteService {

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    ContaCorrenteMapper contaCorrenteMapper;

    @Autowired
    OperacaoMapper operacaoMapper;

    public ContaCorrenteDTO visualizarDados() {
        ContaCorrente contaCorrente = contaCorrenteRepository.findByCliente(SecurityUtils.getClienteAutenticado());

        return contaCorrenteMapper.toDTO(contaCorrente);
    }

    public List<OperacaoDTO> visualizarOperacoes() {
        ContaCorrente contaCorrente = contaCorrenteRepository.findByCliente(SecurityUtils.getClienteAutenticado());
        List<OperacaoDTO> operacoes = Stream.concat(contaCorrente.getOperacoesEntrada().stream(), contaCorrente.getOperacoesSaida().stream()).map(operacao -> operacaoMapper.toDto(operacao)).toList();
        return operacoes;
    }

}
