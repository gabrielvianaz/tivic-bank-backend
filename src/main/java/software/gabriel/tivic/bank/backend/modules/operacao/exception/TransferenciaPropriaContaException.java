/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.exception;

/**
 *
 * @author gabriel
 */
public class TransferenciaPropriaContaException extends RuntimeException {

    public TransferenciaPropriaContaException() {
        super("Você não pode realizar uma transferência para sua própria conta!");
    }

}
