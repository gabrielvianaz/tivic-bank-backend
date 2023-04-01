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
public class SaqueDTO extends OperacaoDTO {
    
    private ContaCorrenteDTO contaOrigem;

    @JsonIgnoreProperties(value = {"saldo"})
    public ContaCorrenteDTO getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaCorrenteDTO contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaCorrenteDTO getContaDestino() {
        return null;
    }

}
