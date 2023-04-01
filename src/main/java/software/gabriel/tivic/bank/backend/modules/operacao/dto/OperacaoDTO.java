/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrente;

/**
 *
 * @author gabriel
 */
public abstract class OperacaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDateTime momento;

    @Digits(integer = 10, fraction = 2, message = "O campo 'valor' deve possuir apenas duas casas decimais!")
    @Positive(message = "O campo 'valor' deve possuir valor superior a 0!")
    @NotNull(message = "O campo 'valor' é obrigatório!")
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public abstract ContaCorrente getContaOrigem();
    
    public abstract ContaCorrente getContaDestino();

}
