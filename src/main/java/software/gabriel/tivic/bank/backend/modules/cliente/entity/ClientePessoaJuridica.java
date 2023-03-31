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
@DiscriminatorValue(value = "PJ")
public class ClientePessoaJuridica extends Cliente {

    @NotNull(message = "O campo 'cnpj' é obrigatório!")
    @Column(unique = true, length = 14)
    private String cnpj;

    @NotNull(message = "O campo 'razaoSocial' é obrigatório!")
    private String razaoSocial;

    @NotNull(message = "O campo 'nomeFantasia' é obrigatório!")
    private String nomeFantasia;

    @NotNull(message = "O campo 'dataFundacao' é obrigatório!")
    private LocalDate dataFundacao;

    public ClientePessoaJuridica(String cnpj, String razaoSocial, String nomeFantasia, LocalDate dataFundacao, String telefone, String email, String senha) {
        super(telefone, email, senha);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.dataFundacao = dataFundacao;
    }

    public ClientePessoaJuridica() {
    }

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

    @Override
    public String getDocumento() {
        return getCnpj();
    }

}
