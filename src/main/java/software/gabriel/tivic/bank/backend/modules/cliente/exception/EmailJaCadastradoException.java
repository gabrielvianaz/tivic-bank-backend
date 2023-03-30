/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.exception;

/**
 *
 * @author gabriel
 */
public class EmailJaCadastradoException extends RuntimeException {

    public EmailJaCadastradoException() {
        super("O e-mail informado já se encontra cadastrado!");
    }
    
}
