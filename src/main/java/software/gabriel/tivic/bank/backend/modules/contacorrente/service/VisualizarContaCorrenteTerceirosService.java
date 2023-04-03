/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.tivic.bank.backend.modules.contacorrente.dto.ContaCorrenteDTO;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrente;
import software.gabriel.tivic.bank.backend.modules.contacorrente.exception.ContaNaoEncontradaException;
import software.gabriel.tivic.bank.backend.modules.contacorrente.mapper.ContaCorrenteMapper;
import software.gabriel.tivic.bank.backend.modules.contacorrente.repository.ContaCorrenteRepository;

/**
 *
 * @author gabriel
 */
@Service
public class VisualizarContaCorrenteTerceirosService {

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    ContaCorrenteMapper contaCorrenteMapper;

    public ContaCorrenteDTO visualizar(Long id) {
        ContaCorrente contaCorrente = contaCorrenteRepository.findById(id).orElseThrow(ContaNaoEncontradaException::new);
        contaCorrente.setSaldo(null);

        return contaCorrenteMapper.toDTO(contaCorrente);
    }

}
