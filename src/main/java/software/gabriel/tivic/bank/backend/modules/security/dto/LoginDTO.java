/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author gabriel
 */
public class LoginDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "O campo 'email' é obrigatório!")
    @NotEmpty(message = "O campo 'email' não pode estar vazio!")
    @Email(message = "E-mail inválido!")
    private String email;

    @NotNull(message = "O campo 'senha' é obrigatório!")
    @NotEmpty(message = "O campo 'senha' não pode estar vazio!")
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
