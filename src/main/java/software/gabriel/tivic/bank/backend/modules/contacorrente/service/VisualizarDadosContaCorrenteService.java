/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.tivic.bank.backend.modules.contacorrente.dto.ContaCorrenteDTO;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrente;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrentePessoaFisica;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrentePessoaJuridica;
import software.gabriel.tivic.bank.backend.modules.contacorrente.repository.ContaCorrenteRepository;
import software.gabriel.tivic.bank.backend.modules.security.util.SecurityUtils;
import software.gabriel.tivic.bank.backend.modules.contacorrente.mapper.ContaCorrentePessoaFisicaMapper;
import software.gabriel.tivic.bank.backend.modules.contacorrente.mapper.ContaCorrentePessoaJuridicaMapper;

/**
 *
 * @author gabriel
 */
@Service
public class VisualizarDadosContaCorrenteService {

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    ContaCorrentePessoaFisicaMapper contaCorrentePessoaFisicaMapper;

    @Autowired
    ContaCorrentePessoaJuridicaMapper contaCorrentePessoaJuridicaMapper;

    public ContaCorrenteDTO visualizar() {
        ContaCorrente contaCorrente = contaCorrenteRepository.findByCliente(SecurityUtils.getClienteAutenticado());
        
        if (contaCorrente instanceof ContaCorrentePessoaFisica contaCorrentePessoaFisica) {
            return contaCorrentePessoaFisicaMapper.toDTO(contaCorrentePessoaFisica);
        } else if (contaCorrente instanceof ContaCorrentePessoaJuridica contaCorrentePessoaJuridica) {
            return contaCorrentePessoaJuridicaMapper.toDTO(contaCorrentePessoaJuridica);
        }
        
        return null;
    }

}
