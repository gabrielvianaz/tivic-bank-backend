/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.Cliente;

/**
 *
 * @author gabriel
 */
@Entity
@DiscriminatorValue(value = "PJ")
public class ContaCorrentePessoaJuridica extends ContaCorrente {

    public ContaCorrentePessoaJuridica(Cliente cliente) {
        super(cliente);
    }

    public ContaCorrentePessoaJuridica() {
    }

}
