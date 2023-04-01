/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import software.gabriel.tivic.bank.backend.modules.contacorrente.dto.ContaCorrenteDTO;

/**
 *
 * @author gabriel
 */
public class DepositoDTO extends OperacaoDTO {

    @JsonIgnoreProperties(value = {"saldo"})
    private ContaCorrenteDTO contaDestino;

    public ContaCorrenteDTO getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaCorrenteDTO contaDestino) {
        this.contaDestino = contaDestino;
    }

    public ContaCorrenteDTO getContaOrigem() {
        return null;
    }

}
