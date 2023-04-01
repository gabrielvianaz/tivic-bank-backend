/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.service;

import software.gabriel.tivic.bank.backend.modules.cliente.exception.CnpjJaCadastradoException;
import software.gabriel.tivic.bank.backend.modules.cliente.exception.CpfJaCadastradoException;
import software.gabriel.tivic.bank.backend.modules.cliente.exception.EmailJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import software.gabriel.tivic.bank.backend.modules.cliente.dto.ClienteDTO;
import software.gabriel.tivic.bank.backend.modules.cliente.dto.ClientePessoaFisicaDTO;
import software.gabriel.tivic.bank.backend.modules.cliente.dto.ClientePessoaJuridicaDTO;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.Cliente;
import software.gabriel.tivic.bank.backend.modules.cliente.mapper.ClientePessoaFisicaMapper;
import software.gabriel.tivic.bank.backend.modules.cliente.mapper.ClientePessoaJuridicaMapper;
import software.gabriel.tivic.bank.backend.modules.cliente.repository.ClienteRepository;
import software.gabriel.tivic.bank.backend.modules.contacorrente.service.CadastrarContaCorrenteService;

/**
 *
 * @author gabriel
 */
@Service
public class CadastrarClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClientePessoaFisicaMapper clientePessoaFisicaMapper;

    @Autowired
    ClientePessoaJuridicaMapper clientePessoaJuridicaMapper;
    
    @Autowired
    CadastrarContaCorrenteService cadastrarContaCorrenteService;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void cadastrar(ClienteDTO clienteDTO) {
        validarEmail(clienteDTO.getEmail());
        Cliente cliente = null;

        if (clienteDTO instanceof ClientePessoaFisicaDTO clientePessoaFisicaDTO) {
            validarClientePessoaFisica(clientePessoaFisicaDTO);
            cliente = clientePessoaFisicaMapper.toEntity(clientePessoaFisicaDTO);
        } else if (clienteDTO instanceof ClientePessoaJuridicaDTO clientePessoaJuridicaDTO) {
            validarClientePessoaJuridica(clientePessoaJuridicaDTO);
            cliente = clientePessoaJuridicaMapper.toEntity(clientePessoaJuridicaDTO);
        }
        
        cliente.setSenha(bCryptPasswordEncoder.encode(cliente.getSenha()));
        
        cliente = clienteRepository.save(cliente);
        cadastrarContaCorrenteService.cadastrar(cliente);
    }

    private void validarEmail(String email) {
        if (emailJaCadastrado(email)) {
            throw new EmailJaCadastradoException();
        }
    }

    private void validarClientePessoaFisica(ClientePessoaFisicaDTO clientePessoaFisica) {
        if (cpfJaCadastrado(clientePessoaFisica.getCpf())) {
            throw new CpfJaCadastradoException();
        }
    }

    private void validarClientePessoaJuridica(ClientePessoaJuridicaDTO clientePessoaJuridica) {
        if (cnpjJaCadastrado(clientePessoaJuridica.getCnpj())) {
            throw new CnpjJaCadastradoException();
        }
    }

    private boolean emailJaCadastrado(String email) {
        return clienteRepository.findByEmail(email) != null;
    }

    private boolean cpfJaCadastrado(String cpf) {
        return clienteRepository.findByCpf(cpf) != null;
    }

    private boolean cnpjJaCadastrado(String cnpj) {
        return clienteRepository.findByCnpj(cnpj) != null;
    }

}
