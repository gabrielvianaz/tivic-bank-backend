/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author gabriel
 */
public class ClientePessoaJuridicaDTO extends ClienteDTO {

    @NotNull(message = "O campo 'cnpj' é obrigatório!")
    @NotEmpty(message = "O campo 'cnpj' não pode estar vazio!")
    @CNPJ(message = "CNPJ inválido!")
    private String cnpj;

    @NotNull(message = "O campo 'razaoSocial' é obrigatório!")
    @NotEmpty(message = "O campo 'razaoSocial' não pode estar vazio!")
    private String razaoSocial;

    @NotNull(message = "O campo 'nomeFantasia' é obrigatório!")
    @NotEmpty(message = "O campo 'nomeFantasia' não pode estar vazio!")
    private String nomeFantasia;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "O campo 'dataFundacao' é obrigatório!")
    private LocalDate dataFundacao;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

}
