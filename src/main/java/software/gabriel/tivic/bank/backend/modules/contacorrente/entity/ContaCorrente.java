/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.Cliente;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Operacao;

/**
 *
 * @author gabriel
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
    @Type(value = ContaCorrentePessoaFisica.class, name = "PF"),
    @Type(value = ContaCorrentePessoaJuridica.class, name = "PJ"),})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
public abstract class ContaCorrente implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, scale = 2)
    private Double saldo;

    @OneToOne
    @JoinColumn(name = "cliente_id", unique = true, nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "contaOrigem")
    private List<Operacao> operacoesSaida = new ArrayList<>();

    @OneToMany(mappedBy = "contaDestino")
    private List<Operacao> operacoesEntrada = new ArrayList<>();

    public ContaCorrente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ContaCorrente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Operacao> getOperacoesSaida() {
        return operacoesSaida;
    }

    public void setOperacoesSaida(List<Operacao> operacoesSaida) {
        this.operacoesSaida = operacoesSaida;
    }

    public List<Operacao> getOperacoesEntrada() {
        return operacoesEntrada;
    }

    public void setOperacoesEntrada(List<Operacao> operacoesEntrada) {
        this.operacoesEntrada = operacoesEntrada;
    }

    public void adicionarSaldo(Double valor) {
        setSaldo(getSaldo() + valor);
    }

    public void subtrairSaldo(Double valor) {
        setSaldo(getSaldo() - valor);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContaCorrente other = (ContaCorrente) obj;
        return Objects.equals(this.cliente, other.cliente);
    }

}
