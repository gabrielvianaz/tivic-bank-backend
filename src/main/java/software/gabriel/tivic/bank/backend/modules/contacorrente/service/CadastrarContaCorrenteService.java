/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.conta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.Cliente;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.ClientePessoaFisica;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.ClientePessoaJuridica;
import software.gabriel.tivic.bank.backend.modules.conta.entity.ContaCorrente;
import software.gabriel.tivic.bank.backend.modules.conta.entity.ContaCorrentePessoaFisica;
import software.gabriel.tivic.bank.backend.modules.conta.entity.ContaCorrentePessoaJuridica;
import software.gabriel.tivic.bank.backend.modules.conta.repository.ContaCorrenteRepository;

/**
 *
 * @author gabriel
 */
@Service
public class CadastrarContaCorrenteService {

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    public void cadastrar(Cliente cliente) {
        ContaCorrente contaCorrente = null;

        if (cliente instanceof ClientePessoaFisica) {
            contaCorrente = new ContaCorrentePessoaFisica(cliente);
        } else if (cliente instanceof ClientePessoaJuridica) {
            contaCorrente = new ContaCorrentePessoaJuridica(cliente);
        }
        
        contaCorrente.setSaldo(0.0);        
        contaCorrenteRepository.save(contaCorrente);
    }

}
