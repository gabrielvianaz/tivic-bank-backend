/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.exception;

/**
 *
 * @author gabriel
 */
public class CnpjJaCadastradoException extends RuntimeException {

    public CnpjJaCadastradoException() {
        super("O CNPJ informado já se encontra cadastrado!");
    }
    
}
