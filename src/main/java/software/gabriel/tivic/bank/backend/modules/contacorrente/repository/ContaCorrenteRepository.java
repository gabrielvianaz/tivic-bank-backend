/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.Cliente;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrente;

/**
 *
 * @author gabriel
 */
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {
    
    ContaCorrente findByCliente(Cliente cliente);
    
}
