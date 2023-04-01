/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.exception;

/**
 *
 * @author gabriel
 */
public class ContaDestinoNaoEncontradaException extends RuntimeException {
    
    public ContaDestinoNaoEncontradaException() {
        super("A conta de destino informada não foi encontrada!");
    }
    
}
