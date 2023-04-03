/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author gabriel
 */
@JsonInclude(Include.NON_NULL)
public abstract class ClienteDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull(message = "O campo 'email' é obrigatório!")
    @NotEmpty(message = "O campo 'email' não pode estar vazio!")
    @Email(message = "E-mail inválido!")
    private String email;

    @NotNull(message = "O campo 'senha' é obrigatório!")
    @NotEmpty(message = "O campo 'senha' não pode estar vazio!")
    private String senha;

    @NotNull(message = "O campo 'telefone' é obrigatório!")
    @NotEmpty(message = "O campo 'telefone' não pode estar vazio!")
    private String telefone;        

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public abstract String getNome();

}
