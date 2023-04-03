/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author gabriel
 */
public class ClientePessoaFisicaDTO extends ClienteDTO {

    @NotNull(message = "O campo 'cpf' é obrigatório!")
    @NotEmpty(message = "O campo 'cpf' não pode estar vazio!")
    @CPF(message = "CPF inválido!")
    private String cpf;

    @NotNull(message = "O campo 'nome' é obrigatório!")
    @NotEmpty(message = "O campo 'nome' não pode estar vazio!")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "O campo 'dataNascimento' é obrigatório!")
    private LocalDate dataNascimento;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
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

}
