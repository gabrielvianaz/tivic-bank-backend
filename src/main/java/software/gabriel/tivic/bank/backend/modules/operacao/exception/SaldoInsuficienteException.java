/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.exception;

/**
 *
 * @author gabriel
 */
public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException() {
        super("A conta não possui saldo suficiente para realizar a operação!");
    }

}
