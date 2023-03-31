/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 *
 * @author gabriel
 */
@Entity
@DiscriminatorValue(value = "PF")
public class ClientePessoaFisica extends Cliente {

    @NotNull(message = "O campo 'cpf' é obrigatório!")
    @Column(unique = true, length = 11)
    private String cpf;

    @NotNull(message = "O campo 'nome' é obrigatório!")    
    private String nome;

    @NotNull(message = "O campo 'dataNascimento' é obrigatório!")
    private LocalDate dataNascimento;

    public ClientePessoaFisica(String cpf, String nome, LocalDate dataNascimento, String telefone, String email, String senha) {
        super(telefone, email, senha);
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public ClientePessoaFisica() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String getDocumento() {
        return getCpf();
    }

}
