/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrente;

/**
 *
 * @author gabriel
 */
public class SaqueDTO extends OperacaoDTO {

    @JsonIgnoreProperties({"saldo, operacoesEntrada, operacoesSaida"})
    private ContaCorrente contaOrigem;

    @Override
    public ContaCorrente getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaCorrente contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    @Override
    public ContaCorrente getContaDestino() {
        return null;
    }

}
