/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.conta.dto;

import java.io.Serializable;

/**
 *
 * @author gabriel
 */
public class ContaCorrenteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Double saldo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
