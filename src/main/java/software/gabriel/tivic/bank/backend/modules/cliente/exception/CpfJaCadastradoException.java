/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.exception;

/**
 *
 * @author gabriel
 */
public class CpfJaCadastradoException extends RuntimeException {

    public CpfJaCadastradoException() {
        super("O CPF informado já se encontra cadastrado!");
    }
    
}
