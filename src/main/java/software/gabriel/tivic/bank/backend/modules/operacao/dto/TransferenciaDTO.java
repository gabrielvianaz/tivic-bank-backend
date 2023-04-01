/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrente;

/**
 *
 * @author gabriel
 */
public class TransferenciaDTO extends OperacaoDTO {

    @JsonIgnoreProperties({"saldo, operacoesEntrada, operacoesSaida"})
    private ContaCorrente contaOrigem;

    @JsonIgnoreProperties({"saldo, operacoesEntrada, operacoesSaida"})
    @NotNull(message = "O campo 'contaDestino' é obrigatório!")
    private ContaCorrente contaDestino;

    @Override
    public ContaCorrente getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaCorrente contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    @Override
    public ContaCorrente getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaCorrente contaDestino) {
        this.contaDestino = contaDestino;
    }

}
