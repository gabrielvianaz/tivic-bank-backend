/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import software.gabriel.tivic.bank.backend.modules.contacorrente.dto.ContaCorrenteDTO;

/**
 *
 * @author gabriel
 */
public class TransferenciaDTO extends OperacaoDTO {

    @JsonIgnoreProperties(value = {"saldo"})
    private ContaCorrenteDTO contaOrigem;

    @JsonIgnoreProperties(value = {"saldo"})
    @NotNull(message = "O campo 'contaDestino' é obrigatório!")
    private ContaCorrenteDTO contaDestino;

    public ContaCorrenteDTO getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaCorrenteDTO contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaCorrenteDTO getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaCorrenteDTO contaDestino) {
        this.contaDestino = contaDestino;
    }

}
