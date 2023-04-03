/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.exception;

/**
 *
 * @author gabriel
 */
public class ContaNaoEncontradaException extends RuntimeException {
    
    public ContaNaoEncontradaException() {
        super("A conta informada não foi encontrada!");
    }
    
}
