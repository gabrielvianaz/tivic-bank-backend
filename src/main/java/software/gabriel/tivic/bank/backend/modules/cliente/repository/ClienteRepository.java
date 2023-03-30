/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.Cliente;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.ClientePessoaFisica;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.ClientePessoaJuridica;

/**
 *
 * @author gabriel
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    Cliente findByEmail(String email);
    
    ClientePessoaFisica findByCpf(String cpf);
    
    ClientePessoaJuridica findByCnpj(String cnpj);
            
}
